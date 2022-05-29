package com.example.mvc.controller

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/api")
@Validated
class DeleteApiController {

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,

        @NotNull(message = "age 값이 누락 되었습니다.")
        @Min(value = 20, message = "age 는 20보다 커야 합니다.")
        @RequestParam(name = "age") _age: Int
    ): String {
        return "$_name $_age"
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @PathVariable(value = "name") _name: String,

        @NotNull(message = "age 값이 누락 되었습니다.")
        @Min(value = 20, message = "age 는 20보다 커야 합니다.")
        @PathVariable(name = "age") _age: Int
    ): String {
        return "$_name $_age"
    }

}