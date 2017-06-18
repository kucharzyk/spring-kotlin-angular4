package com.shardis.common

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ShardisTestApplication

fun main(args: Array<String>) {
    SpringApplication.run(ShardisTestApplication::class.java, *args)
}

