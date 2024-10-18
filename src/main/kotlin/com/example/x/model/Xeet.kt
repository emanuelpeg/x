package com.example.x.model

import org.springframework.data.annotation.Id
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.time.LocalDateTime
import java.util.UUID

@Table("xeets")
data class Xeet (
            @Id
            @PrimaryKey
            val xid: UUID,
            val userName: String,
            val text: String,
            val createDate: LocalDateTime = LocalDateTime.now()) {

}