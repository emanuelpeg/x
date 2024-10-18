package com.example.x.service

import com.example.x.model.Xeet
import java.util.UUID
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface XeetService {

    fun get(xid: UUID): Mono<Xeet?>

    fun get(): Flux<Xeet?>

    fun save(xeet: Xeet) : Mono<Xeet>

}