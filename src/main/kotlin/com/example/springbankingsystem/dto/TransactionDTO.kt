package com.example.springbankingsystem.dto

import com.example.springbankingsystem.entity.*
import java.sql.Timestamp
import java.time.LocalDateTime

data class TransactionDTO(
    var id: Long?=null,
    var fromCustomer: String,
    var toCustomer: String,
//    var transferredAmount: String,
//    var money: Money? = null,
    var number: Int,
    var withDrawl: WithDrawl,
    var transfer: Transfer,
    var deposit: Deposit,
    var userId: Long,
    var user: User?= null,
    var transactionTime: Timestamp = Timestamp.valueOf(LocalDateTime.now())
)