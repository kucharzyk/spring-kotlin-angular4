package com.shardis.query.repositories

import com.shardis.query.domain.Permission
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface PermissionRepository : CrudRepository<Permission, Long>
