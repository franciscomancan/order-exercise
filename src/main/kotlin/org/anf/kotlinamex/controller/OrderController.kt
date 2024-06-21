package org.anf.kotlinamex.controller

import org.anf.kotlinamex.domain.Order
import org.anf.kotlinamex.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * Urls:
 *  http://localhost:8080/swagger-ui/index.html
 */

@RestController
@RequestMapping("/order")
class OrderController {

    @GetMapping("/message")
    fun getMessage(): String {
        return "you got this!!!"
    }

    @PostMapping("/create")
    fun createOrder(@RequestBody order: OrderRequest): ResponseEntity<Order> {
        val order = OrderService().createOrder(order.items)
        println(order)
        return ResponseEntity.ok(order)
    }

    data class OrderRequest(val items: Map<String,Int>)
}