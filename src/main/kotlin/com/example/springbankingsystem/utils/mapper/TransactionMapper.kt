package com.example.springbankingsystem.utils.mapper

import com.example.springbankingsystem.dto.TransactionDTO
import com.example.springbankingsystem.entity.Transaction
import org.springframework.stereotype.Component

@Component
class TransactionMapper: Mapper<TransactionDTO, Transaction> {
    override fun fromEntity(entity: Transaction): TransactionDTO = TransactionDTO (
        entity.id,
        entity.fromCustomer,
        entity.toCustomer,
        entity.transferredAmount,
        entity.userId,
        entity.user,
        entity.transactionTime
    )

    override fun toEntity(domain: TransactionDTO): Transaction = Transaction(
        domain.id,
        domain.fromCustomer,
        domain.toCustomer,
        domain.transferredAmount,
        domain.userId,
        domain.user,
        domain.transactionTime
    )
}