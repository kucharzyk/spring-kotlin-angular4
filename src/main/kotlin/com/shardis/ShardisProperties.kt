package com.shardis

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "shardis")
open class ShardisProperties {

    var version = "unknown"
    var security = Security()

    open class Security {
        var header = "Authorization"
        var parameter = "auth_token"
        var jwtSecret: String = "secret"
        var passwordSecret: String = "secret"
        var tokenValidityInSeconds: Long = 3600L
        var tokenValidityInSecondsForRememberMe: Long = 3600L
    }
}
