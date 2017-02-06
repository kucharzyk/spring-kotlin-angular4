package com.shardis.repositories

import com.shardis.domain.Role
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface RoleRepository : CrudRepository<Role, Long>
