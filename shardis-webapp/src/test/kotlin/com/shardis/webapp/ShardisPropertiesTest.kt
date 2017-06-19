package com.shardis.webapp

import com.shardis.core.config.properties.support.ShardisProperties
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ShardisPropertiesTest {

    @Autowired
    lateinit var shardisProperties: ShardisProperties

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {

    }

    @Test
    fun propertiesAreSet() {
        assertNotNull("properties must be autowired", shardisProperties)
        assertNotNull("version can't be null", shardisProperties.version)
        assertNotEquals("version must be defined", "unknown", shardisProperties.version)
        assertTrue("version should contains three parts separated by dots", shardisProperties.version.split('.').size == 3)
    }

}
