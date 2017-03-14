package com.shardis

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

@SpringBootApplication
@EnableConfigurationProperties(ShardisProperties::class)
open class ShardisApplication

fun main(args: Array<String>) {
    SpringApplication.run(ShardisApplication::class.java, *args)
}

