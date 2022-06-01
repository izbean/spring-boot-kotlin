package com.example.mvc.advice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

//@RestControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler(value=[RuntimeException::class])
    fun exception(e: RuntimeException): String {
        return "Server Error"
    }

    @ExceptionHandler(value=[IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String> {
        return ResponseEntity.internalServerError().body("Index Error")
    }

}