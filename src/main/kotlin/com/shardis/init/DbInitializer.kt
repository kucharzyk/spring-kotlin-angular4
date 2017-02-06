package com.shardis.init

import com.shardis.domain.Permission
import com.shardis.domain.Role
import com.shardis.domain.User
import com.shardis.repositories.PermissionRepository
import com.shardis.repositories.RoleRepository
import com.shardis.repositories.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import javax.transaction.Transactional


@Transactional
@Component
class DbInitializer(
    val permissionRepository: PermissionRepository,
    val roleRepository: RoleRepository,
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder
) {

    @PostConstruct
    open fun dbInit() {

        if (userRepository.findAll().none()) {

            log.info("Db initialization")

            val p1 = Permission("PERM_ONE")
            val p2 = Permission("PERM_TWO")
            val p3 = Permission("PERM_THREE")

            log.info("saving permissions")

            with(permissionRepository) {
                save(p1)
                save(p2)
                save(p3)
            }


            val roleAdmin = Role("ROLE_ADMIN", mutableSetOf(p1, p2, p3))
            val roleUser = Role("ROLE_USER", mutableSetOf(p1))

            log.info("saving roles")

            with(roleRepository) {
                save(roleAdmin)
                save(roleUser)
            }

            val admin = User(
                username = "admin",
                password = passwordEncoder.encode("xxxxxx"),
                firstName = "Admin",
                lastName = "Admin",
                email = "admin@admin.com",
                enabled = true,
                expired = false,
                locked = false,
                roles = mutableSetOf(roleAdmin)
            )

            val user = User(
                username = "user",
                password = passwordEncoder.encode("xxxxxx"),
                firstName = "User",
                lastName = "User",
                email = "user@user.com",
                enabled = true,
                expired = false,
                locked = false,
                roles = mutableSetOf(roleUser)
            )

            log.info("saving users")

            with(userRepository) {
                save(admin)
                save(user)
            }

        }
    }

    companion object {
        val log = LoggerFactory.getLogger(DbInitializer::class.java)
    }
}
