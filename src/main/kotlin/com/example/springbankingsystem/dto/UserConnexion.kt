package com.example.springbankingsystem.dto

import javax.validation.constraints.Email

data class UserConnexion (
    var username: String,
    var password: String,
    var email: String
    )