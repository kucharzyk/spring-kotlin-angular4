package com.shardis.security.support

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

object SecurityUtils {

    fun getLoggedUserName(): String {
        val principal: Any = SecurityContextHolder.getContext().authentication.principal
        if (principal is UserDetails) {
            return principal.username
        } else {
            return principal.toString()
        }
    }
}
