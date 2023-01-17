package com.example.springbankingsystem.service

import com.example.springbankingsystem.dto.UserConnexion
import com.example.springbankingsystem.entity.User
import com.example.springbankingsystem.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired private constructor(private var userRepository: UserRepository){

    fun getUsers(): List<User> = userRepository.findAll()

    fun getOne(id: Long): User = userRepository
        .findById(id)
        .orElseThrow{
            IllegalArgumentException("User with this $id was not found")
        }

    fun saveUser(user: User): User = userRepository.save(user)

    fun updateUser(id: Long, userInput: User): User {
        val userFound = getOne(id)

        userFound.username = userInput.username
        userFound.lastname = userInput.lastname
        userFound.firstname = userInput.firstname
        userFound.accountNumber = userInput.accountNumber
        userFound.address = userInput.address
        userFound.email = userInput.email
        userInput.password = userInput.password
        userFound.city = userInput.city
        userFound.country = userInput.country
        userFound.currentBalance = userInput.currentBalance
        userFound.phoneNumber = userInput.phoneNumber

        return userRepository.save(userFound)
    }

    fun deleteUSer(id:Long): String{
        val userFound = getOne(id)

        userRepository.delete(userFound)
        return "User deleted!"
    }

    fun login(userData: UserConnexion): User {
        val user = userRepository
            .findByUsername(userData.username)
            .orElseThrow{IllegalArgumentException("User not Found")
            }
        if (user.password == userData.password && user.email == userData.email){
            return user
        }
        throw IllegalArgumentException("username or password or email not correct!")
    }
}