package com.shardis.rest

import com.shardis.security.jwt.JwtTokenAuthService
import com.shardis.security.support.SecurityUtils
import com.shardis.security.support.ShardisUserDetails
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController()
@RequestMapping(path = arrayOf("/api/auth"))
class AuthController(val jwtTokenAuthService: JwtTokenAuthService) {

    @RequestMapping(path = arrayOf("/test/token"), method = arrayOf(RequestMethod.GET))
    fun token(request: HttpServletRequest): String {
        val authorities = listOf(SimpleGrantedAuthority("ROLE_TEST"))
        return jwtTokenAuthService.createToken(
            UsernamePasswordAuthenticationToken(
                ShardisUserDetails(1, "test", "test", authorities),
                "",
                authorities
            ),
            request
        )
    }


    @RequestMapping(path = arrayOf("/principal"), method = arrayOf(RequestMethod.GET))
    fun principal(): String? {
        return SecurityUtils.getLoggedUser()?.username
    }

}
