package com.example.springbankingsystem.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "transaction")
data class Transaction (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?=null,
    var fromCustomer: String,
    var toCustomer: String,
    var transferredAmount: String,
    @Column(name = "user_id")
    var userId: Long,
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    @JsonIgnore
    var user: User?= null,
    var transactionTime: Timestamp = Timestamp.valueOf(LocalDateTime.now())
)