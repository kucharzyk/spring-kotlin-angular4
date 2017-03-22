package com.shardis.query.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.envers.Audited
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass


@MappedSuperclass
@Audited(auditParents = arrayOf(BaseEntity::class))
@EntityListeners(AuditingEntityListener::class)
open class AuditedEntity : BaseEntity() {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @JsonIgnore
    private var createdDate: ZonedDateTime? = null

    @CreatedBy
    @Column(updatable = false)
    @JsonIgnore
    private var createdBy: Long? = null

    @LastModifiedDate
    @JsonIgnore
    private var updatedDate: ZonedDateTime? = null

    @LastModifiedBy
    @JsonIgnore
    private var updatedBy: Long? = null

}
