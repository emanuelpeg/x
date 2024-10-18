package com.example.x

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories

@SpringBootApplication
@EnableReactiveCassandraRepositories
class XApplication

fun main(args: Array<String>) {
	runApplication<XApplication>(*args)
}
