package dev.hbrown.springsecuritydemo.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @GetMapping(path = ["/"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun home() = """{
        |"allowed": "all"
        |}""".trimMargin()

    @GetMapping(path = ["/user"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun user() = """{
        |"allowed": "user"
        |}""".trimMargin()

    @GetMapping(path = ["/admin"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun admin() = """{
        |"allowed": "admin"
        |}""".trimMargin()

}
