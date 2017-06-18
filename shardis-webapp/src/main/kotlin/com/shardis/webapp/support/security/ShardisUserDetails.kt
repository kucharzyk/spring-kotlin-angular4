package com.shardis.webapp.support.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

class ShardisUserDetails(
    val userId: Long,
    username: String,
    password: String = "",
    authorities: Collection<GrantedAuthority>
) : User(username, password, authorities)

