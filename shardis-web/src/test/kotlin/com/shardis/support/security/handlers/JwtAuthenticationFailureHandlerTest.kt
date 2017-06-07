package com.shardis.support.security.handlers

import org.junit.Assert
import org.junit.Test
import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.mock.web.MockHttpServletResponse
import javax.servlet.http.HttpServletResponse


class JwtAuthenticationFailureHandlerTest {

    @Test
    fun `must return 401 code on authentication failure`() {
        val handler = JwtAuthenticationFailureHandler()
        val request = MockHttpServletRequest()
        val response = MockHttpServletResponse()

        handler.onAuthenticationFailure(request, response, null)

        Assert.assertEquals(HttpServletResponse.SC_UNAUTHORIZED, response.status)
    }

}
