package com.shardis.query.domain

import org.springframework.security.core.GrantedAuthority
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "roles")
@SequenceGenerator(allocationSize = 1, name = "sequenceIdGenerator", sequenceName = "sequence_roles")
class Role(
    @Column(nullable = false, length = 64, unique = true) val name: String,
    @ManyToMany(fetch = FetchType.LAZY) val permissions: MutableSet<Permission> = mutableSetOf()
) : BaseEntity(), Serializable, GrantedAuthority {
    override fun getAuthority() = name
}
