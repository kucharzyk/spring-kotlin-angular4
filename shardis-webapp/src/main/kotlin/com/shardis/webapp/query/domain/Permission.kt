package com.shardis.webapp.query.domain

import org.hibernate.envers.Audited
import org.springframework.security.core.GrantedAuthority
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Audited
@Table(name = "permissions")
@SequenceGenerator(allocationSize = 1, name = "sequenceIdGenerator", sequenceName = "sequence_permissions")
class Permission(
    @Column(nullable = false, length = 64, unique = true) val name: String
) : AuditedEntity(), GrantedAuthority {
    override fun getAuthority() = name
}
