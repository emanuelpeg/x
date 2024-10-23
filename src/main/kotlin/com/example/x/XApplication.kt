package com.example.x

import com.vaadin.flow.component.page.AppShellConfigurator
import com.vaadin.flow.component.page.Push
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories

@SpringBootApplication
@EnableReactiveCassandraRepositories
@Push
class XApplication : AppShellConfigurator

fun main(args: Array<String>) {
	runApplication<XApplication>(*args)
}
