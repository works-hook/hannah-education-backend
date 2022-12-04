package com.hannah.education

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HannahEducationBackendApplication

fun main(args: Array<String>) {
    runApplication<HannahEducationBackendApplication>(*args)
}

@RestController
class PingController {

    @GetMapping("/ping")
    fun ping(): String {
        return "ok"
    }

}
