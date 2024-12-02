package com.example.demo.config

import org.springframework.data.auditing.DateTimeProvider
import org.springframework.stereotype.Component
import java.time.ZonedDateTime
import java.time.temporal.TemporalAccessor
import java.util.*

@Component("dateTimeProvider")
class CustomDateTimeProvider: DateTimeProvider {
    override fun getNow(): Optional<TemporalAccessor> = Optional.of(ZonedDateTime.now())
}
