package com.shardis.core.service

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals
import kotlin.test.assertNotNull


@RunWith(SpringRunner::class)
@SpringBootTest
class CommonServiceTest {

    @Autowired
    lateinit var commonService: CommonService

    @Test
    fun giveMeTheAnswer() {
        assertNotNull(commonService)
        assertEquals(42, commonService.giveMeTheAnswer())
    }

}
