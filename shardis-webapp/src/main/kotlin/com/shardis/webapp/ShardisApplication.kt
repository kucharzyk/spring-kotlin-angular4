package com.shardis.webapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = arrayOf(
    "com.shardis.core",
    "com.shardis.query",
    "com.shardis.webapp"
))
@EnableJpaRepositories(basePackages = arrayOf(
    "com.shardis.core",
    "com.shardis.query",
    "com.shardis.webapp"
))
@EntityScan(basePackages = arrayOf(
    "org.axonframework.eventsourcing.eventstore.jpa",
    "org.axonframework.eventhandling.saga.repository.jpa",
    "org.axonframework.eventhandling.tokenstore.jpa",
    "com.shardis.core",
    "com.shardis.query",
    "com.shardis.webapp"
))
open class ShardisApplication

fun main(args: Array<String>) {
    SpringApplication.run(ShardisApplication::class.java, *args)
}

