package com.shardis.webapp.support.security.handlers

import com.shardis.webapp.services.jwt.JwtTokenAuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
open class JwtAuthenticationSuccessHandler : AuthenticationSuccessHandler {

    @Autowired
    private lateinit var jwtTokenAuthService: JwtTokenAuthService

    override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {
        val testToken = jwtTokenAuthService.createToken(authentication, request)
        response.writer.use {
            it.print(testToken)
            it.flush()
        }
        response.status = HttpServletResponse.SC_OK
    }
}
