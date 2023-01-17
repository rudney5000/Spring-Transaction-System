package com.example.springbankingsystem.controller

import com.example.springbankingsystem.entity.Transaction
import com.example.springbankingsystem.service.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionController @Autowired private constructor(private val transactionService: TransactionService){
    @GetMapping("/transactions")
    fun getTransactionList(): List<Transaction> = transactionService.getTransactions()

    @GetMapping("/transactions/{id}")
    fun getTransactionById(@PathVariable id: Long): Transaction = transactionService.getOne(id)

    @PostMapping("/transactions")
    fun doTransaction(@RequestBody transaction: Transaction): Transaction = transactionService.saveTransaction(transaction)

    @PutMapping("/transactions/{id}")
    fun updateTransaction(@RequestBody transaction: Transaction, @PathVariable id: Long): Transaction = transactionService.updateTransaction(transaction, id)

    @DeleteMapping("/transactions/{id}")
    fun cancelTransaction(@PathVariable id: Long): String = transactionService.cancelTransaction(id)
}