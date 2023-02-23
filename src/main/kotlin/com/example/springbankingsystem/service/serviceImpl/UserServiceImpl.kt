package com.example.springbankingsystem.service.serviceImpl

import com.example.springbankingsystem.dto.UserDTO
import com.example.springbankingsystem.repository.UserRepository
import com.example.springbankingsystem.service.UserService
import com.example.springbankingsystem.utils.exceptions.UserException
import com.example.springbankingsystem.utils.mapper.UserMapper
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
): UserService {
    override fun getUser(id: Long): UserDTO {
        val optionalUser = userRepository.findById(id)
        val user = optionalUser.orElseThrow { UserException("User with id $id is not present") }
        return userMapper.fromEntity(user)
    }

    override fun getUsers(): List<UserDTO> {
        val users = userRepository.getAllByUsers()

        if (users.isEmpty())
            throw UserException("List of users is empty.")

        return users.map {
            userMapper.fromEntity(it)
        }
    }

    override fun saveUser(userDTO: UserDTO): UserDTO {
        val userMap = userMapper.toEntity(userDTO)
        val user = userRepository.save(userMap)
        return userMapper.fromEntity(user)
    }

    override fun updateUser(userDTO: UserDTO): UserDTO {
        val exist = userRepository.existsById(userDTO.id)
        if (!exist)
            throw UserException("User with id ${userDTO.id} is not present")

        if(userDTO.phoneNumber == 0 || userDTO.username == "Default user")
            throw UserException("Complete user object is excepted")

        userRepository.save(userMapper.toEntity(userDTO))
        return userDTO
    }

    override fun deleteUser(id: Long): String {
        val exist = userRepository.existsById(id)
        if (!exist)
            throw UserException("User with id $id is not present")

        userRepository.deleteById(id)
        return "User deleted"
    }

}