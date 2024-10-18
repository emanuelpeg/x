package com.example.x.service

import com.example.x.dao.XeetDao
import com.example.x.dao.XeetRepository
import com.example.x.model.Xeet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class XeetServiceImp : XeetService {

    @Autowired
    lateinit var dao : XeetDao

    override fun get(xid: UUID): Mono<Xeet?> = dao.get(xid)

    override fun get(): Flux<Xeet?> = dao.get()

    override fun save(xeet: Xeet) : Mono<Xeet> = dao.save(xeet)

}