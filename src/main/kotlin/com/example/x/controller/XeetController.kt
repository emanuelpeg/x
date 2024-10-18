package com.example.x.controller

import com.example.x.model.Xeet
import com.example.x.service.XeetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/xeets")
class XeetController {

    @Autowired
    lateinit var service : XeetService

    @GetMapping("/{xid}")
    fun get(@PathVariable xid: String): Mono<Xeet?> {
        val id = UUID.fromString(xid)
        return service.get(id)
    }

    @GetMapping
    fun get(): Flux<Xeet?> = service.get()

    @PostMapping
    fun save(@RequestBody xeet: Xeet) : Mono<Xeet> = service.save(xeet)
}