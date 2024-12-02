package com.example.demo.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import java.util.TimeZone

@ConfigurationProperties(
    prefix = "r2dbc",
    ignoreUnknownFields = true,
)
data class R2dbcProperties(
    val hostname: String,
    val port: Int,
    val username: String,
    val password: String,
    val database: String,
    val schema: String,
    val timezone: TimeZone,
    val autoDetectExtensions: Boolean,
    val tcpNoDelay: Boolean,
    val tcpKeepAlive: Boolean,
    val pool: R2dbcPoolProperties
)
