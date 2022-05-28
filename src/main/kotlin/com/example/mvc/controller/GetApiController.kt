package com.example.mvc.controller

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello Kotlin."
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(
        @PathVariable name: String,
        @PathVariable age: Int
    ): String {
        return "입력된 이름은 $name 이고, 나이는 $age 입니다."
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(
        @PathVariable(value = "name") _name: String,
        @PathVariable(value = "age") _age: Int
    ): String {
        val name = "kotlin"

        return "입력된 이름은 $_name 이고, 나이는 $_age 입니다."
    }

    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam name: String,
        @RequestParam age: Int
    ): String {
        return "입력된 이름은 $name 이고, 나이는 $age 입니다."
    }

    @GetMapping("/get-mapping/query-param/object")
    fun queryObject(
        userRequest: UserRequest
    ): UserRequest {
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(
        @RequestParam map: Map<String, Any>
    ): Map<String, Any> {
        val phoneNumber = map["phone-number"]
        return map
    }

}