package com.shardis.query.repositories

import com.shardis.query.domain.Role
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface RoleRepository : CrudRepository<Role, Long>
