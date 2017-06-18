package com.shardis.webapp.query.repositories

import com.shardis.webapp.query.domain.Role
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface RoleRepository : CrudRepository<Role, Long>
