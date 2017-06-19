package com.shardis.webapp.support.security.filters

import com.shardis.core.config.properties.support.ShardisProperties
import com.shardis.webapp.services.jwt.JwtTokenAuthService
import io.jsonwebtoken.ExpiredJwtException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.util.StringUtils
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationTokenFilter(val shardisProperties: ShardisProperties, val jwtTokenAuthService: JwtTokenAuthService) : GenericFilterBean() {

    companion object {
        val log: Logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter::class.java)
    }


    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        try {
            val httpServletRequest = servletRequest as HttpServletRequest
            val authToken = resolveToken(httpServletRequest)
            authToken?.let {
                if (StringUtils.hasText(authToken)) {
                    if (jwtTokenAuthService.validateToken(authToken)) {
                        val authentication = jwtTokenAuthService.getAuthentication(authToken)
                        SecurityContextHolder.getContext().authentication = authentication
                    }
                }
            }
            filterChain.doFilter(servletRequest, servletResponse)
        } catch (ex: ExpiredJwtException) {
            log.info("Security exception for user {} - {}", ex.claims.subject, ex.message)
            (servletResponse as HttpServletResponse).status = HttpServletResponse.SC_UNAUTHORIZED
        }

    }

    private fun resolveToken(request: HttpServletRequest): String? {
        val header: String? = request.getHeader(shardisProperties.security.header)
        if (header != null && header.startsWith("Bearer ")) {
            val authToken = header.substring(7)
            return authToken
        }
        val authToken = request.getParameter(shardisProperties.security.parameter)
        if (StringUtils.hasText(authToken)) {
            return authToken
        }
        return null
    }


}
