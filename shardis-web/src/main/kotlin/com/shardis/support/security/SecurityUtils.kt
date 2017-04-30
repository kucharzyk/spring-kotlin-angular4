package com.shardis.support.security

import org.springframework.security.core.context.SecurityContextHolder

object SecurityUtils {

    fun getLoggedUser(): ShardisUserDetails? {
        val principal: Any? = SecurityContextHolder.getContext()?.authentication?.principal

        return when (principal) {
            is ShardisUserDetails -> principal
            else -> null
        }
    }

}
