package com.example.demo.config


import com.example.demo.properties.R2dbcProperties
import io.r2dbc.pool.ConnectionPool
import io.r2dbc.pool.ConnectionPoolConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.postgresql.codec.EnumCodec
import io.r2dbc.spi.ConnectionFactory

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions
import org.springframework.data.r2dbc.dialect.PostgresDialect
import org.springframework.data.r2dbc.mapping.R2dbcMappingContext
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.data.relational.core.mapping.DefaultNamingStrategy
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableR2dbcAuditing
@EnableTransactionManagement
@EnableR2dbcRepositories
class R2dbcConfig(
    val r2dbcProperties: R2dbcProperties,
) {

    @Bean
    fun connectionPool(): ConnectionPool = PostgresqlConnectionFactory(
        PostgresqlConnectionConfiguration
            .builder()
            .apply {
                addHost(r2dbcProperties.hostname, r2dbcProperties.port)
                username(r2dbcProperties.username)
                password(r2dbcProperties.password)
                database(r2dbcProperties.database)
                schema(r2dbcProperties.schema)
                autodetectExtensions(r2dbcProperties.autoDetectExtensions)
                tcpNoDelay(r2dbcProperties.tcpNoDelay)
                tcpKeepAlive(r2dbcProperties.tcpKeepAlive)
                codecRegistrar(
                    EnumCodec
                        .builder()
                     /*   .withEnum("measurement_unit", MeasurementUnit::class.java)
                        .withEnum("customer_type", CustomerType::class.java)
                        .withEnum("artist_contract", ArtistContract::class.java)
                        .withEnum("ownership_type", OwnershipType::class.java)
                        .withEnum("currency", Currency::class.java)
                        .withEnum("sales_status", SalesStatus::class.java)
                        .withEnum("deal_type", DealType::class.java)
                        .withEnum("bills_status", BillsStatus::class.java)
                        .withEnum("artwork_status", ArtworkStatus::class.java)
                        .withEnum("nationality_type",NationalityType::class.java)
                        .withEnum("artworks_quality", ArtworksQuality::class.java)
                        .withEnum("artwork_type", ArtworkType::class.java)
                        .withEnum("payment_method", PaymentMethod::class.java)
                        .withEnum("payment_status", PaymentStatus::class.java)
                        .withEnum("payment_type", PaymentType::class.java)
                        .withEnum("schedule_type", ScheduleType::class.java)
                        .withEnum("bills_authenticate_issue_type", BillsAuthenticateIssueType::class.java)*/
                        .build()
                )
            }
            .build()
    ).let { connectionFactory ->
        ConnectionPool(
            ConnectionPoolConfiguration
                .builder()
                .apply {
                    connectionFactory(connectionFactory)
                    maxSize(r2dbcProperties.pool.maxSize)
                    initialSize(r2dbcProperties.pool.initialSize)
                    maxIdleTime(r2dbcProperties.pool.maxIdleTime)
                }
                .build()
        )
    }.apply {
        warmup().block()
    }

    @Bean
    fun reactiveTransactionManager(connectionFactory: ConnectionFactory) = R2dbcTransactionManager(connectionFactory)

    @Bean
    fun r2dbcMappingContext(
        r2dbcCustomConversions: R2dbcCustomConversions,
    ): R2dbcMappingContext = R2dbcMappingContext(DefaultNamingStrategy.INSTANCE).apply {
        setSimpleTypeHolder(r2dbcCustomConversions.simpleTypeHolder)
        isForceQuote = true
    }

    @Bean
    fun r2dbcCustomConversions(): R2dbcCustomConversions = R2dbcCustomConversions
        .of(
            PostgresDialect.INSTANCE,
            /*listOf(
                MeasurementUnitEnumWriteSupport(),
                FromHashSetToStringWritingConverter(),
                ArtistContractEnumWriteSupport(),
                OwnershipTypeEnumWriteSupport(),
                CurrencyEnumWriteSupport(),
                SalesStatusEnumWriteSupport(),
                DealTypeEnumWriteSupport(),
                BillsStatusEnumWriteSupport(),
                ArtworksStatusEnumWriteSupport(),
                NationalityTypeEnumWriteSupport(),
                ArtworksQualityEnumWriteSupport(),
                ArtworkTypeEnumWriteSupport(),
                PaymentMethodEnumWriteSupport(),
                PaymentStatusEnumWriteSupport(),
                PaymentTypeEnumWriteSupport(),
                ScheduleTypeEnumWriteSupport(),
                BillsAuthenticateIssueTypeEnumWriteSupport(),
            )*/
        )
}
