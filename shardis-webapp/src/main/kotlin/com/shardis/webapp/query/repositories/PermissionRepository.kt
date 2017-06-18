package com.shardis.webapp.query.repositories

import com.shardis.webapp.query.domain.Permission
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface PermissionRepository : CrudRepository<Permission, Long>
