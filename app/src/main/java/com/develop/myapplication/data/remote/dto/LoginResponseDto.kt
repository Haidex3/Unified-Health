package com.develop.myapplication.data.remote.dto;

import com.google.gson.JsonObject

data class LoginResponseDto(
    val message: String,
    val user: UserDto,
    val type: String,
    val token: String
)