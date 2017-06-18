package com.shardis.webapp.support.view.resolvers

import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.util.StringUtils
import org.springframework.web.servlet.resource.ResourceResolver
import org.springframework.web.servlet.resource.ResourceResolverChain
import java.io.IOException
import javax.servlet.http.HttpServletRequest


class PushStateResourceResolver : ResourceResolver {

    private val index = ClassPathResource("/static/index.html")
    private val handledExtensions = listOf("html", "js", "json", "csv", "css", "png", "svg", "eot", "ttf", "woff", "appcache", "jpg", "jpeg", "gif", "ico","map")
    private val ignoredPaths = listOf("api")

    override fun resolveResource(request: HttpServletRequest, requestPath: String, locations: List<Resource>, chain: ResourceResolverChain): Resource? {
        return resolve(requestPath, locations)
    }

    override fun resolveUrlPath(resourcePath: String, locations: List<Resource>, chain: ResourceResolverChain): String? {
        val resolvedResource = resolve(resourcePath, locations) ?: return null
        return try {
             resolvedResource.url.toString()
        } catch (e: IOException) {
            resolvedResource.filename
        }

    }

    private fun resolve(requestPath: String, locations: List<Resource>): Resource? = when {
            isIgnored(requestPath) -> null
            isHandled(requestPath) -> locations
                .map { loc -> createRelative(loc, requestPath) }
                .filterNotNull()
                .filter { it.exists() }
                .firstOrNull()
            else -> index
        }

    private fun createRelative(resource: Resource, relativePath: String): Resource? = try {
            resource.createRelative(relativePath)
        } catch (e: IOException) {
            null
        }

    private fun isIgnored(path: String): Boolean = ignoredPaths.contains(path)

    private fun isHandled(path: String): Boolean {
        val extension = StringUtils.getFilenameExtension(path)
        return handledExtensions.any { it == extension }
    }
}
