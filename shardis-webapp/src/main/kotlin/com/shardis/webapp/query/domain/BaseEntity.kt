package com.shardis.webapp.query.domain

import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "sequenceIdGenerator")
    @Column(nullable = false, updatable = false)
    var id: Long? = null

    @Column(nullable = false, updatable = false)
    val uuid: String = UUID.randomUUID().toString()

    @Column(nullable = true, updatable = false)
    @Version
    val version: Long? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class.java != other::class.java) return false

        val that = other as BaseEntity?

        return uuid == that!!.uuid
    }

    override fun hashCode(): Int {
        return Objects.hash(uuid)
    }

}
