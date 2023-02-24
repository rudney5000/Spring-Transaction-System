package com.example.springbankingsystem.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "session")
data class Session (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var lastMessage: String,
    var number: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "transaction_id")
    var transaction: Transaction,

    @CreationTimestamp
    var createdAt: Timestamp?=null,
    @UpdateTimestamp
    var updatedAt: Timestamp? = null,
)