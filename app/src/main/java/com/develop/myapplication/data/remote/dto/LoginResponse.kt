package com.develop.myapplication.data.remote.dto

data class LoginResponse(
    val message: String,
    val user: UserDto,
    val type: String,
    val token: String
)