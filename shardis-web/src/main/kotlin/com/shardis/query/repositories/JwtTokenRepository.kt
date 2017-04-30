package com.shardis.query.repositories

import com.shardis.query.domain.JwtToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface JwtTokenRepository : CrudRepository<JwtToken, Long>
