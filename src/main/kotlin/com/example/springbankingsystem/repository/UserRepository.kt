package com.example.springbankingsystem.repository

import com.example.springbankingsystem.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository: JpaRepository<User, Long> {

    fun findByUsername(username: String): Optional<User>
}