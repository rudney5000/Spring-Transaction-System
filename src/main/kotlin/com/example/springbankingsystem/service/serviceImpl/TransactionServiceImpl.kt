package com.example.springbankingsystem.service.serviceImpl

import com.example.springbankingsystem.dto.TransactionDTO
import com.example.springbankingsystem.repository.TransactionRepository
import com.example.springbankingsystem.service.TransactionService
import com.example.springbankingsystem.utils.exceptions.TransactionException
import com.example.springbankingsystem.utils.exceptions.UserException
import com.example.springbankingsystem.utils.mapper.TransactionMapper
import org.springframework.stereotype.Service

@Service
class TransactionServiceImpl(
    private val transactionRepository: TransactionRepository,
    private val transactionMapper: TransactionMapper
): TransactionService {
    override fun getTransaction(id: Long): TransactionDTO {
        val optionalTransaction = transactionRepository.findById(id)
        val transaction = optionalTransaction.orElseThrow { TransactionException("Transaction with id $id is not present") }
        return transactionMapper.fromEntity(transaction)
    }

    override fun getTransactions(): List<TransactionDTO> {
        val transactions = transactionRepository.getAllByTransactions()

        if (transactions.isEmpty())
            throw TransactionException("List of users is empty.")

        return transactions.map {
            transactionMapper.fromEntity(it)
        }
    }

    override fun createTransaction(transactionDTO: TransactionDTO): TransactionDTO {
        val transactionMap = transactionMapper.toEntity(transactionDTO)
        val transaction = transactionRepository.save(transactionMap)
        return transactionMapper.fromEntity(transaction)
    }

    override fun updateTransaction(transactionDTO: TransactionDTO): TransactionDTO {
        val exist = transactionDTO.id?.let { transactionRepository.existsById(it) }
        if (!exist!!)
            throw UserException("User with id ${transactionDTO.id} is not present")

        if(transactionDTO.fromCustomer == "Default fromCustomer" || transactionDTO.toCustomer == "Default toCustomer")
            throw UserException("Complete user object is excepted")

        transactionRepository.save(transactionMapper.toEntity(transactionDTO))
        return transactionDTO
    }

    override fun deleteTransaction(id: Long): String {
        val exist = transactionRepository.existsById(id)
        if (!exist)
            throw TransactionException("transaction with id $id is not present")

        transactionRepository.deleteById(id)
        return "Transaction deleted"
    }
}