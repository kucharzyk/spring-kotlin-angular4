package com.shardis.security

import com.shardis.domain.Role
import com.shardis.domain.User
import com.shardis.repositories.UserRepository
import com.shardis.security.support.ShardisUserDetails
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Transactional(readOnly = true)
@Service
open class ShardisUserDetailsService(val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails? {

        val user: User? = userRepository.findByUsername(username)

        user?.let {
            val authorities = mutableSetOf<GrantedAuthority>()
            authorities.addAll(user.roles)
            authorities.addAll(user.roles.flatMap(Role::permissions))
            return ShardisUserDetails(user.id!!, user.username, user.password, authorities)
        }

        return null
    }

}
