package com.shardis.webapp.query.repositories


import com.shardis.webapp.query.domain.JwtToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface JwtTokenRepository : CrudRepository<JwtToken, Long>
