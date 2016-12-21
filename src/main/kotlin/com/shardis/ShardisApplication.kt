package com.shardis

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ShardisApplication {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(ShardisApplication::class.java, *args)
        }
    }
}
