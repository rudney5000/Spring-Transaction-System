package com.example.springbankingsystem.service

import com.example.springbankingsystem.entity.Transaction
import com.example.springbankingsystem.repository.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionService @Autowired private constructor(private var transactionRepository: TransactionRepository) {

    fun getTransactions(): List<Transaction> {
        return transactionRepository.findAll()
    }

    fun getTransactionByUserId(userId: Long): List<Transaction> = transactionRepository.findByUserId(userId)

    fun getOne(id: Long): Transaction = transactionRepository
        .findById(id)
        .orElseThrow {
            IllegalArgumentException("Transaction with id = $id was not found")
        }

    fun saveTransaction(transaction: Transaction): Transaction{
        return transactionRepository.save(transaction)
    }

    fun updateTransaction(transactionInput: Transaction, id: Long): Transaction {
        val transactionToUpdate = getOne(id)
        transactionToUpdate.fromCustomer = transactionInput.fromCustomer
        transactionToUpdate.toCustomer = transactionInput.toCustomer
        transactionToUpdate.transferredAmount = transactionInput.transferredAmount

        return transactionRepository.save(transactionToUpdate)
    }

    fun cancelTransaction(id: Long): String{
        val transactionToCancel = getOne(id)

        transactionRepository.delete(transactionToCancel)
        return "transaction canceled!"
    }
}