package com.shardis.core.config.properties

import com.shardis.core.config.properties.support.ShardisProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(ShardisProperties::class)
open class PropertiesConfig
