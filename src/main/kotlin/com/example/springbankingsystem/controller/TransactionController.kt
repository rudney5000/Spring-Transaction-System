package com.example.springbankingsystem.controller

import com.example.springbankingsystem.dto.TransactionDTO
import com.example.springbankingsystem.dto.UserDTO
import com.example.springbankingsystem.entity.Transaction
import com.example.springbankingsystem.service.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionController(
    private val transactionService: TransactionService
    ){

    @GetMapping("/transactions/{id}")
    fun getTransaction(@PathVariable id: Long) =
        ResponseEntity.ok(transactionService.getTransaction(id))

    @PostMapping("/transactions")
    fun createTransaction(@RequestBody transactionDTO: TransactionDTO): ResponseEntity<TransactionDTO>{
        return ResponseEntity(transactionService.createTransaction(transactionDTO), HttpStatus.CREATED)
    }

    @GetMapping("/transactions")
    fun getTransactions(): ResponseEntity<List<TransactionDTO>> =
        ResponseEntity.ok(transactionService.getTransactions())

    @PutMapping("/transactions")
    fun updateTransaction(@RequestBody transactionDTO: TransactionDTO): ResponseEntity<TransactionDTO> =
        ResponseEntity.ok(transactionService.updateTransaction(transactionDTO))

    @DeleteMapping("/transactions/{id}")
    fun deleteTransaction(@PathVariable id: Long): ResponseEntity<String> =
        ResponseEntity(transactionService.deleteTransaction(id), HttpStatus.NO_CONTENT)

//    @GetMapping("/transactions")
//    fun getTransactionList(): List<Transaction> = transactionService.getTransactions()
//
//    @GetMapping("/transactions/{id}")
//    fun getTransactionById(@PathVariable id: Long): Transaction = transactionService.getOne(id)
//
//    @PostMapping("/transactions")
//    fun doTransaction(@RequestBody transaction: Transaction): Transaction = transactionService.saveTransaction(transaction)
//
//    @PutMapping("/transactions/{id}")
//    fun updateTransaction(@RequestBody transaction: Transaction, @PathVariable id: Long): Transaction = transactionService.updateTransaction(transaction, id)
//
//    @DeleteMapping("/transactions/{id}")
//    fun cancelTransaction(@PathVariable id: Long): String = transactionService.cancelTransaction(id)
}