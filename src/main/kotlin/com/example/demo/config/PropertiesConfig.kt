package com.example.demo.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = ["com.example.demo.properties"])
class PropertiesConfig {
}
