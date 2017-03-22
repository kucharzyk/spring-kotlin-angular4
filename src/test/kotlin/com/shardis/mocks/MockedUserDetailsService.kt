package com.shardis.mocks

import com.shardis.support.security.ShardisUserDetails
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service("mockedUserDetailsService")
class MockedUserDetailsService : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails? {
        return when {
            ADMIN_USER == username -> ShardisUserDetails(1L, username, "", listOf(
                SimpleGrantedAuthority("ROLE_USER"),
                SimpleGrantedAuthority("ROLE_ADMIN")
            ))

            REGULAR_USER == username -> ShardisUserDetails(2L, username, "", listOf(
                SimpleGrantedAuthority("ROLE_ADMIN")
            ))

            else -> null
        }
    }

    companion object {
        const val ADMIN_USER = "admin"
        const val REGULAR_USER = "user"
    }

}
