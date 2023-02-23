package com.example.springbankingsystem.utils.mapper

import com.example.springbankingsystem.dto.UserDTO
import com.example.springbankingsystem.entity.User
import org.springframework.stereotype.Component

@Component
class UserMapper: Mapper<UserDTO, User> {
    override fun fromEntity(entity: User): UserDTO = UserDTO(
        entity.id,
        entity.username,
        entity.firstname,
        entity.lastname,
        entity.email,
        entity.password,
        entity.country,
        entity.city,
        entity.phoneNumber,
        entity.address,
        entity.accountNumber,
        entity.currentBalance,
        entity.transactions,
        entity.createdAt,
        entity.updatedAt
    )

    override fun toEntity(domain: UserDTO): User = User (
        domain.id,
        domain.username,
        domain.firstname,
        domain.lastname,
        domain.email,
        domain.password,
        domain.country,
        domain.city,
        domain.phoneNumber,
        domain.address,
        domain.accountNumber,
        domain.currentBalance,
        domain.transactions,
        domain.createdAt,
        domain.updatedAt
    )
}