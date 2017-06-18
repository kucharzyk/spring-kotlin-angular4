package com.shardis.webapp.config

import com.shardis.webapp.support.view.resolvers.PushStateResourceResolver
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

import java.util.concurrent.TimeUnit

@Configuration
open class ViewConfig : WebMvcConfigurerAdapter() {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry
            .addResourceHandler("/**")
            .addResourceLocations("classpath:/static/")
            .setCachePeriod(TimeUnit.HOURS.toSeconds(24L).toInt())
            .resourceChain(true)
            .addResolver(PushStateResourceResolver())
    }
}
