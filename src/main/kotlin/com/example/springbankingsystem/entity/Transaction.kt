package com.example.springbankingsystem.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "transaction")
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?=null,
    var fromCustomer: String,
    var toCustomer: String,
//    var transferredAmount: String,
    var number: Int,

//    @Enumerated(EnumType.STRING)
//    var money: Money? = null,

    @OneToOne(
        cascade = [CascadeType.ALL],
    )
    @JoinColumn(
        name = "retrait_id",
    )
    var withDrawl: WithDrawl,

    @OneToOne(
        cascade = [CascadeType.ALL],
    )
    @JoinColumn(
        name = "transfer_id",
    )
    var transfer: Transfer,

    @OneToOne(
        cascade = [CascadeType.ALL],
    )
    @JoinColumn(
        name = "depot_id",
    )
    var deposit: Deposit,

    @Column(name = "user_id")
    var userId: Long,

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    @JsonIgnore
    var user: User?= null,

    var transactionTime: Timestamp = Timestamp.valueOf(LocalDateTime.now())
)