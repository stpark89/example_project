package com.example.demo.config

import com.example.demo.converters.jackson.JacksonZonedDateTimeDeserializer
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Configuration
@EnableWebFlux
class WebFluxConfig: WebFluxConfigurer {
    companion object {
        val serializationDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[.SSS][XXX]")
        val deserializationDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[.SSS][XXX]")
    }

    @Bean
    fun objectMapper() = ObjectMapper().apply {
        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        disable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
        disable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)
        disable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)
        enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
        enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING)
        enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)
        registerModule(
            KotlinModule
                .Builder()
                .apply {
                    configure(KotlinFeature.NullToEmptyCollection, false)
                    configure(KotlinFeature.NullToEmptyMap, false)
                    configure(KotlinFeature.NullIsSameAsDefault, false)
                    configure(KotlinFeature.SingletonSupport, false)
                    configure(KotlinFeature.StrictNullChecks, false)
                }
                .build()
        )
        registerModule(
            JavaTimeModule()
                .apply {
                    addSerializer(ZonedDateTime::class.java, ZonedDateTimeSerializer(serializationDateFormatter))
                    addDeserializer(ZonedDateTime::class.java, JacksonZonedDateTimeDeserializer())
                }
        )
    }

    override fun configureHttpMessageCodecs(configurer: ServerCodecConfigurer) {
        val objectMapper = objectMapper()
        configurer.customCodecs().register(
            Jackson2JsonEncoder(
                objectMapper
            )
        )
        configurer.customCodecs().register(
            Jackson2JsonDecoder(
                objectMapper
            )
        )
        configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)
        super.configureHttpMessageCodecs(configurer)
    }

//    override fun addFormatters(registry: _root_ide_package_.org.springframework.format.FormatterRegistry) {
//        super.addFormatters(registry)
//    }
}
