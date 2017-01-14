package com.shardis.security.support

import org.springframework.security.core.context.SecurityContextHolder

object SecurityUtils {

    fun getLoggedUser(): ShardisUserDetails? {
        val principal: Any = SecurityContextHolder.getContext().authentication.principal
        if (principal is ShardisUserDetails) {
            return principal
        } else {
            return null
        }
    }

}
