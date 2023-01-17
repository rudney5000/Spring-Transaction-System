package com.example.springbankingsystem.repository

import com.example.springbankingsystem.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository: JpaRepository<Transaction, Long> {
    fun findByUserId(userId: Long): List<Transaction>
}