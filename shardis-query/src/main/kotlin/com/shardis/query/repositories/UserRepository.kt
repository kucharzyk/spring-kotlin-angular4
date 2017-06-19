package com.shardis.query.repositories

import com.shardis.query.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findByUsername(username: String): User?
}
