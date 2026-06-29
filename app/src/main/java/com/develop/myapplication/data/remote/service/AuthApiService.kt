package com.develop.myapplication.data.remote.service

import com.develop.myapplication.data.remote.dto.LoginRequestDto
import com.develop.myapplication.data.remote.dto.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("login")
    suspend fun login(
        @Body loginRequest: LoginRequestDto
    ): LoginResponseDto

    @POST("logout")
    suspend fun logout()
}