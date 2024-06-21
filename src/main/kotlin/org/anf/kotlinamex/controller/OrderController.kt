package org.anf.kotlinamex.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/order")
class OrderController {

    @GetMapping("/message")
    fun getMessage(): String {
        return "you got this!!!"
    }


}