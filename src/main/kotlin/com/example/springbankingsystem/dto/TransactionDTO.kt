package com.example.springbankingsystem.dto

import com.example.springbankingsystem.entity.User
import com.fasterxml.jackson.annotation.JsonIgnore
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

data class TransactionDTO(
    var id: Long?=null,
    var fromCustomer: String,
    var toCustomer: String,
    var transferredAmount: String,
//    @Column(name = "user_id")
    var userId: Long,
//    @ManyToOne
//    @JoinColumn(insertable = false, updatable = false)
//    @JsonIgnore
    var user: User?= null,
    var transactionTime: Timestamp = Timestamp.valueOf(LocalDateTime.now())
)