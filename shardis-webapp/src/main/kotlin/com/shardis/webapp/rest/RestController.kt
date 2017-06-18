package com.shardis.webapp.rest


import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = arrayOf("/api"))
class RestController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = arrayOf("/test"))
    fun testEndpoint() = "WORKING"
}
