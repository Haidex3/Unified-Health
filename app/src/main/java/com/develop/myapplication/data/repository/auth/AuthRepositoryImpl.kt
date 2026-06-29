package com.develop.myapplication.data.repository.auth

import android.util.Log
import com.develop.myapplication.data.remote.dto.LoginRequestDto
import com.develop.myapplication.data.remote.dto.LoginResponseDto
import com.develop.myapplication.data.remote.service.AuthApiService
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApiService: AuthApiService
) : AuthRepository {

    override suspend fun login(
        rut: String,
        password: String
    ): LoginResponseDto {

        return try {
            authApiService.login(
                LoginRequestDto(
                    RUT = rut,
                    password = password
                )
            )
        } catch (e: Exception) {
            Log.e("AuthRepository", "Error al iniciar sesión: ${e.message}", e)
            throw e
        }
    }

    override suspend fun logout() {
        try {
            authApiService.logout()
        } catch (e: Exception) {
            Log.e("AuthRepository", "Error al cerrar sesión: ${e.message}", e)
            throw e
        }
    }
}