package com.example.demo.properties

import java.time.Duration

data class R2dbcPoolProperties(
    val enabled: Boolean,
    val initialSize: Int,
    val maxSize: Int,
    val maxIdleTime: Duration,
)
