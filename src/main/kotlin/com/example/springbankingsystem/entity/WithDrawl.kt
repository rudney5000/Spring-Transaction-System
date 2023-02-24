package com.example.springbankingsystem.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "retrait")
data class WithDrawl(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var amount: Int,
//    var message: String,

//    @OneToOne(mappedBy = "withDrawl")
//    var transaction: Transaction,

    @CreationTimestamp
    var createdAt: Timestamp?=null,
    @UpdateTimestamp
    var updatedAt: Timestamp? = null,
)