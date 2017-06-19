package com.shardis.query.schema

import com.shardis.query.schema.support.SchemaExporter
import org.hibernate.dialect.PostgreSQL94Dialect
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import org.springframework.test.context.junit4.SpringRunner
import java.io.File


@RunWith(SpringRunner::class)
@SpringBootTest()
class SchemaExporterTest {

    @Autowired lateinit var env: Environment

    @Test
    fun generateDDL() {
        val exporter = SchemaExporter(
            PostgreSQL94Dialect::class.java.canonicalName,
            listOf("org.axonframework.eventsourcing.eventstore.jpa",
                "org.axonframework.eventhandling.saga.repository.jpa",
                "org.axonframework.eventhandling.tokenstore.jpa",
                "com.shardis.core",
                "com.shardis.query",
                "com.shardis.webapp"),
            env.getProperty("spring.jpa.hibernate.naming.implicit-strategy"),
            env.getProperty("spring.jpa.hibernate.naming.physical-strategy")
        )
        exporter.export(File("schema.sql"))
        Assert.assertTrue(true)
    }
}
