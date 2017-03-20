package com.shardis.config


import org.springframework.context.annotation.Configuration
import org.axonframework.config.EventHandlingConfiguration
import org.springframework.beans.factory.annotation.Autowired


@Configuration
open class AxonConfig {


    @Autowired
    open fun configure(eventHandlingConfiguration: EventHandlingConfiguration) {
        eventHandlingConfiguration.usingTrackingProcessors()
    }

}
