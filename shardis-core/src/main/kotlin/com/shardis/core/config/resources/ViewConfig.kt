package com.shardis.core.config.resources

import com.shardis.core.config.resources.support.PushStateResourceResolver
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

import java.util.concurrent.TimeUnit

@Configuration
open class ViewConfig : WebMvcConfigurer {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry
            .addResourceHandler("/**")
            .addResourceLocations("classpath:/static/")
            .setCachePeriod(TimeUnit.HOURS.toSeconds(24L).toInt())
            .resourceChain(true)
            .addResolver(PushStateResourceResolver())
    }
}
