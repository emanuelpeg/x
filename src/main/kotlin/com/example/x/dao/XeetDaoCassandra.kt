package com.example.x.dao

import com.example.x.model.Xeet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID


@Repository
interface XeetRepository : ReactiveCassandraRepository<Xeet?, UUID?> {

}

@Repository
class XeetDaoCassandra : XeetDao {

    @Autowired
    lateinit var repository : XeetRepository

    override fun get(xid: UUID): Mono<Xeet?> = repository.findById(xid)

    override fun get(): Flux<Xeet?> = repository.findAll()
        .sort { o1, o2 -> o2!!.createDate.compareTo(o1!!.createDate)  }

    override fun save(xeet: Xeet): Mono<Xeet> = repository.save(xeet)
}