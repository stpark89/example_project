package com.example.demo.converters.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class JacksonZonedDateTimeDeserializer : JsonDeserializer<ZonedDateTime>() {
    companion object {
        val deserializationDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[.SSS][XXX]")
    }

    override fun deserialize(jsonParser: JsonParser, deserializationContext: DeserializationContext): ZonedDateTime {
        val epochTime = jsonParser.text.toLongOrNull()
        return if (epochTime != null) {
            ZonedDateTime.ofInstant(
                Instant.ofEpochSecond(epochTime),
                ZoneId.systemDefault()
            )
        } else {
            ZonedDateTime.parse(jsonParser.text, deserializationDateFormatter)
        }
    }
}
