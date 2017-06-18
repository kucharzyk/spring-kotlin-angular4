package com.shardis.webapp.services.security

import com.shardis.webapp.query.domain.Role
import com.shardis.webapp.query.domain.User
import com.shardis.webapp.query.repositories.UserRepository
import com.shardis.webapp.support.security.ShardisUserDetails
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Transactional(readOnly = true)
@Service
open class ShardisUserDetailsService(val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails? {

        val user: User = userRepository.findByUsername(username) ?: throw UsernameNotFoundException("User $username not found")

        val authorities = mutableSetOf<GrantedAuthority>()
        authorities.addAll(user.roles)
        authorities.addAll(user.roles.flatMap(Role::permissions))
        return ShardisUserDetails(user.id!!, user.username, user.password, authorities)


    }

}
