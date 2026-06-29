package com.develop.myapplication.data.repository.auth

import com.develop.myapplication.data.remote.dto.LoginResponseDto

interface AuthRepository {

    suspend fun login(
        rut: String,
        password: String
    ): LoginResponseDto

    suspend fun logout()
}