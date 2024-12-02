package com.example.demo.exceptions

class AppException (
    open val errorCode: String,
    open val errorCodeNumber: Long,
    open val errorDescription: String = "",
    override val message: String?,
    override val cause: Throwable?,
): Throwable()