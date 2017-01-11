package com.shardis.repositories

import com.shardis.domain.JwtToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface JwtTokenRepository : CrudRepository<JwtToken, Long>
