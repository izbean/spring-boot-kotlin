package com.example.mvc.controller

import com.example.mvc.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    @GetMapping
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {
        return age?.let {
            if (it < 20) {
                return ResponseEntity.badRequest().body("age 값은 20보다 커야 합니다.")
            }

            ResponseEntity.ok("OK")
        }?: kotlin.run {
            return ResponseEntity.badRequest().body("age 값이 누락 되었습니다.")
        }

        /*
        if (age == null)
            return ResponseEntity.badRequest().body("age 값이 누락 되었습니다.")

        if (age < 20)
            return ResponseEntity.badRequest().body("age 값은 20보다 커야 합니다.")
        */
    }

    @PostMapping
    fun postMapping(@RequestBody userRequest: UserRequest): ResponseEntity<Any> {
        return ResponseEntity.ok(userRequest)
    }

    @PutMapping
    fun putMapping(@RequestBody userRequest: UserRequest): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity.internalServerError().body(null)
    }

}