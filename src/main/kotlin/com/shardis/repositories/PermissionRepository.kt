package com.shardis.repositories

import com.shardis.domain.Permission
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface PermissionRepository : CrudRepository<Permission, Long>
