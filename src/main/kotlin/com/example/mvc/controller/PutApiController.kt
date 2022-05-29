package com.example.mvc.controller

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], value = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping-put"
    }

    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest, bindingResult: BindingResult): Any {

        if (bindingResult.hasErrors()) {
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage

                msg.append("${field.field}: $message\n")
            }

            return ResponseEntity.badRequest().body(msg)
        }

        return UserResponse().apply {
            this.result = Result().apply{
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            this.description = "~~~~"
        }.apply {
            val users = mutableListOf<UserRequest>()
            users.add(userRequest)
            users.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.email = "a@a.com"
                this.address = "a address"
                this.phoneNumber = "010-1111-aaaa"
            })

            users.add(UserRequest().apply {
                this.name = "b"
                this.age = 20
                this.email = "b@b.com"
                this.address = "b address"
                this.phoneNumber = "010-2222-bbbb"
            })

            this.users = users
        }
    }

}