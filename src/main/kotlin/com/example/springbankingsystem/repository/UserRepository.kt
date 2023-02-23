package com.example.springbankingsystem.repository

import com.example.springbankingsystem.entity.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.JpaRepository

//@Repository
interface UserRepository: JpaRepository<User, Long> {

//    fun findByUsername(username: String): Optional<User>
//    fun getAllByUsername(): List<User>
    @Query("SELECT m FROM User as m")
    fun getAllByUsers(): List<User>
}