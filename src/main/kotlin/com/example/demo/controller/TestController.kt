package com.example.demo.controller

import com.example.demo.dto.ApiResult
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test")
class TestController {

    @GetMapping("")
    suspend fun test(): ResponseEntity<ApiResult<String>> {
        return ResponseEntity.ok(ApiResult.success("Hello"))
    }

}