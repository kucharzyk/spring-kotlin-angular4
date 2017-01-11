package com.shardis.security.jwt

import com.shardis.ShardisProperties
import com.shardis.domain.JwtToken
import com.shardis.extensions.toDate
import com.shardis.repositories.JwtTokenRepository
import com.shardis.repositories.UserRepository
import com.shardis.security.support.ShardisUserDetails
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.SignatureException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Service
import java.time.ZonedDateTime
import javax.servlet.http.HttpServletRequest

@Service
open class JwtTokenAuthService(
    private val shardisProperties: ShardisProperties,
    private val userRepository: UserRepository,
    private val jwtTokenRepository: JwtTokenRepository
) {

    companion object {
        val log: Logger = LoggerFactory.getLogger(JwtTokenAuthService::class.java)
        val AUTHORITIES_FIELD = "authorities"
        val USER_ID_FIELD = "user_id"
    }

    fun createToken(authentication: Authentication, request: HttpServletRequest, rememberMe: Boolean = false): String {

        val authorities = authentication.authorities
            .map({ authority -> authority.authority })
            .joinToString(separator = ",")

        val now = ZonedDateTime.now()
        val validity: ZonedDateTime = if (rememberMe) {
            now.plusSeconds(shardisProperties.security.tokenValidityInSecondsForRememberMe)
        } else {
            now.plusSeconds(shardisProperties.security.tokenValidityInSeconds)
        }

        val userDetails = authentication.principal as ShardisUserDetails
        val loggedUser = userRepository.findOne(userDetails.userId)

        val jwtToken = JwtToken(
            active = true,
            expirationDate = validity,
            invalidated = false,
            invalidationDate = null,
            ipAdress = request.remoteAddr,
            user = loggedUser
        )

        jwtTokenRepository.save(jwtToken)

        return Jwts.builder()
            .setId(jwtToken.id.toString())
            .setIssuedAt(now.toDate())
            .setNotBefore(now.toDate())
            .setExpiration(validity.toDate())
            .setIssuer("Shardis")
            .setSubject(authentication.name)
            .claim(USER_ID_FIELD, userDetails.userId)
            .claim(AUTHORITIES_FIELD, authorities)
            .signWith(SignatureAlgorithm.HS512, shardisProperties.security.jwtSecret)
            .compact()
    }

    fun getAuthentication(token: String): Authentication {
        val claims = Jwts.parser()
            .setSigningKey(shardisProperties.security.jwtSecret)
            .parseClaimsJws(token)
            .body

        val authorities = claims[AUTHORITIES_FIELD].toString()
            .split(",")
            .map(::SimpleGrantedAuthority)

        val principal = ShardisUserDetails(claims[USER_ID_FIELD].toString().toLong(), claims.subject, "", authorities)

        return UsernamePasswordAuthenticationToken(principal, "", authorities)
    }

    fun validateToken(authToken: String): Boolean {
        try {
            val claims = Jwts.parser().setSigningKey(shardisProperties.security.jwtSecret).parseClaimsJws(authToken)
            val tokenId: Long? = claims.body.id?.toLong()
            tokenId?.let {
                val jwtToken = jwtTokenRepository.findOne(tokenId)
                return jwtToken.active && !jwtToken.invalidated
            }
            return false
        } catch (e: SignatureException) {
            log.info("Invalid JWT signature: " + e.message)
            return false
        }

    }

}
