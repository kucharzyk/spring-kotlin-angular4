package com.shardis.webapp.auth

import com.shardis.webapp.ShardisProperties
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner::class)
class AuthControllerTests {

    @Autowired
    private lateinit var context: WebApplicationContext

    @Autowired
    private lateinit var shardisProperties: ShardisProperties

    private lateinit var mockMvc: MockMvc

    @Before
    fun setup() {
        this.mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply<DefaultMockMvcBuilder>(SecurityMockMvcConfigurers.springSecurity())
            .build()
    }

    @Test
    fun emptyTest() {
    }

    @Test
    fun requestToken() {

        val tokenResult = this.mockMvc
            .perform(MockMvcRequestBuilders.get("/api/auth/test/token"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

        val token = tokenResult.response.contentAsString

        assert(token.split(".").size == 3)

        val principalResult = this.mockMvc
            .perform(
                MockMvcRequestBuilders
                    .get("/api/auth/principal")
                    .header(shardisProperties.security.header, arrayOf("Bearer $token"))
            )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

        Assert.assertEquals("test", principalResult.response.contentAsString)
    }

}
