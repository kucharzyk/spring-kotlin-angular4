package com.shardis.auth

import com.shardis.mocks.MockedUserDetailsService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithUserDetails
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner::class)
class AuthControllerMockedTests {

    @Autowired
    private lateinit var context: WebApplicationContext

    private lateinit var mockMvc: MockMvc

    @Before
    fun setup() {
        this.mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .build()
    }


    @Test
    @WithUserDetails(value = MockedUserDetailsService.ADMIN_USER, userDetailsServiceBeanName = "mockedUserDetailsService")
    fun mockUser() {

        val principalResult = this.mockMvc
            .perform(MockMvcRequestBuilders.get("/api/auth/principal"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

        Assert.assertEquals("admin", principalResult.response.contentAsString)
    }
}
