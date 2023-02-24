package com.example.springbankingsystem.controller

import com.example.springbankingsystem.dto.UserConnexion
import com.example.springbankingsystem.dto.UserDTO
import com.example.springbankingsystem.entity.User
import com.example.springbankingsystem.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Long) =
        ResponseEntity.ok(userService.getUser(id))

    @PostMapping("/users")
    fun createUser(@RequestBody userDTO: UserDTO): ResponseEntity<UserDTO>{
        return ResponseEntity(userService.createUser(userDTO), HttpStatus.CREATED)
    }

    @GetMapping("/users")
    fun getUsers(): ResponseEntity<List<UserDTO>> =
        ResponseEntity.ok(userService.getUsers())

    @PutMapping("/users/")
    fun updateUser(@RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> =
        ResponseEntity.ok(userService.updateUser(userDTO))

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<String> =
        ResponseEntity(userService.deleteUser(id), HttpStatus.NO_CONTENT)

//    @GetMapping("/users")
//    fun getUserList(): List<User> = userService.getUsers()
//
//    @GetMapping("/users/{id}")
//    fun getUser(@PathVariable id: Long): User = userService.getOne(id)
//
//    @PostMapping("/users")
//    fun createUser(@RequestBody user: User): User = userService.saveUser(user)
//
//    @PostMapping("/login")
//    fun loginUser(@RequestBody @Valid userData: UserConnexion): User = userService.login(userData)
//
//    @PutMapping("/users/{id}")
//    fun updateUser(@PathVariable id: Long, @RequestBody user: User): User = userService.updateUser(id, user)
//
//    @DeleteMapping("users/{id}")
//    fun deleteUser(@PathVariable id: Long): String = userService.deleteUSer(id)
}