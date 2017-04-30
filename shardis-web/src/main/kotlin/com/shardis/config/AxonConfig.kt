package com.shardis.config


import org.axonframework.config.EventHandlingConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration


@Configuration
open class AxonConfig {


    @Autowired
    open fun configure(eventHandlingConfiguration: EventHandlingConfiguration) {
        eventHandlingConfiguration.usingTrackingProcessors()
    }

}
