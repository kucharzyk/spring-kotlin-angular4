package com.shardis.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*


@Entity
@Table(name = "users")
@SequenceGenerator(allocationSize = 1, name = "sequenceIdGenerator", sequenceName = "sequence_user")
class User(
    @Column(nullable = false, length = 64, unique = true) private var username: String,
    @Column(nullable = false, length = 64) private var password: String,
    @Column(nullable = false) private var enabled: Boolean,
    @Column(nullable = false) private var expired: Boolean,
    @Column(nullable = false) private var locked: Boolean,
    @OneToMany(fetch = FetchType.LAZY) var roles: MutableSet<Role> = mutableSetOf()
) : BaseEntity(), UserDetails {
    override fun getUsername() = username
    override fun isCredentialsNonExpired() = !expired
    override fun isAccountNonExpired() = !expired
    override fun isAccountNonLocked() = !locked
    override fun isEnabled() = enabled
    override fun getPassword() = password
    override fun getAuthorities(): MutableSet<GrantedAuthority> {
        val authorities = mutableSetOf<GrantedAuthority>()
        authorities.addAll(roles)
        authorities.addAll(roles.flatMap(Role::permissions))
        return authorities
    }
}
