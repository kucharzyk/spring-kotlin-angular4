package com.shardis.config

import com.shardis.support.security.SecurityUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
open class JpaConfig {

    @Bean(name = arrayOf("auditorProvider"))
    open fun auditorProvider(): AuditorAware<Long?> {
        return AuditorAware { SecurityUtils.getLoggedUser()?.userId }
    }
}
