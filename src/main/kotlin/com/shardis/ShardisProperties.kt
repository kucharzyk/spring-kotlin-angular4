package com.shardis

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "shardis")
open class ShardisProperties {

  var version = "unknown"

}
