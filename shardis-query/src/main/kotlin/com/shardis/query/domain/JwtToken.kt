package com.shardis.query.domain

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "jwt_tokens")
@SequenceGenerator(allocationSize = 1, name = "sequenceIdGenerator", sequenceName = "sequence_jwt_tokens")
class JwtToken(
    @Column(nullable = false, length = 39) var ipAdress: String,
    @Column(nullable = false) var expirationDate: Date,
    @ManyToOne(optional = true) var user: User?, // fixme: should not be optional
    @Column(nullable = false) var active: Boolean = true,
    @Column(nullable = false) var invalidated: Boolean = false,
    @Column(nullable = true) var invalidationDate: Date? = null
) : BaseEntity()
