package com.example.demo.dto

import com.example.demo.exceptions.AppException
import com.fasterxml.jackson.annotation.JsonProperty


data class ApiResult<T>(
    @JsonProperty
    val isSuccess: Boolean,
    @JsonProperty
    val resultCodeValue: Long,
    @JsonProperty
    val payload: T,
    @JsonProperty
    val error: AppException?,
    @JsonProperty
    val errorMessage: String?,
) {
    companion object {
        fun error(e: AppException): ApiResult<Nothing?> = ApiResult(
            isSuccess = false,
            resultCodeValue = e.errorCodeNumber,
            payload = null,
            error = null,
            errorMessage = e.errorDescription,
        )

        fun <T> success(payload: T): ApiResult<T> = ApiResult(
            isSuccess = true,
            resultCodeValue = 0L,
            payload = payload,
            error = null,
            errorMessage = null,
        )
    }
}
