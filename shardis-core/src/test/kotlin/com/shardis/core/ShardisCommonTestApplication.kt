package com.shardis.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ShardisCommonTestApplication

fun main(args: Array<String>) {
    SpringApplication.run(ShardisCommonTestApplication::class.java, *args)
}

