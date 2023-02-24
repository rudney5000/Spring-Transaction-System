package com.example.springbankingsystem.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "Utilisateur")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var username: String,
    var firstname: String,
    var lastname: String,
    var email: String,
    var password: String,
    var country: String,
    var city: String,
    var phoneNumber: Int,
    var address: String,
    var accountNumber: Int,
    var currentBalance: Int,
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "user")
    var transactions: MutableList<Transaction> = mutableListOf(),
    @CreationTimestamp
    var createdAt: Timestamp?=null,
    @UpdateTimestamp
    var updatedAt: Timestamp? = null,
)