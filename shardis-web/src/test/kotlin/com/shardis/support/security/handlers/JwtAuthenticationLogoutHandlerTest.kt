package com.shardis.support.security.handlers

import org.junit.Assert
import org.junit.Test
import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.mock.web.MockHttpServletResponse
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationLogoutHandlerTest {

    @Test
    fun `must return 200 code on logout success`() {
        val handler = JwtAuthenticationLogoutHandler()
        val request = MockHttpServletRequest()
        val response = MockHttpServletResponse()

        handler.onLogoutSuccess(request, response, null)

        Assert.assertEquals(HttpServletResponse.SC_OK, response.status)
    }

}
