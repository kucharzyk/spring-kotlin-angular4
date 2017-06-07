package com.shardis.support.security.handlers

import org.junit.Assert
import org.junit.Test
import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.mock.web.MockHttpServletResponse
import javax.servlet.http.HttpServletResponse


class JwtAuthenticationEntryPointTest {

    @Test
    fun `must return 401 code if not authenticated`() {
        val entryPoint = JwtAuthenticationEntryPoint()
        val request = MockHttpServletRequest()
        val response = MockHttpServletResponse()

        entryPoint.commence(request, response, null)

        Assert.assertEquals(HttpServletResponse.SC_UNAUTHORIZED, response.status)
    }

}
