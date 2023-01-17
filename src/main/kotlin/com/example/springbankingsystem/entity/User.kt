package com.example.springbankingsystem.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Size

@Entity
@Table(name = "Utilisateur")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    @field:Size(min = 3, max = 8, message = "Invalid username! (3-10 characters)")
    var username: String,
    var firstname: String,
    var lastname: String,
    @Email
    var email: String,
    @field:Size(min = 8, max = 15, message = "Invalid password! (8-15 characters)")
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