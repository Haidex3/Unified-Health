package com.develop.myapplication.data.repository.auth

import android.util.Log
import com.develop.myapplication.data.local.datastore.SessionManager
import com.develop.myapplication.data.remote.dto.LoginRequestDto
import com.develop.myapplication.data.remote.dto.LoginResponseDto
import com.develop.myapplication.data.remote.service.AuthApiService
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApiService: AuthApiService,
    private val sessionManager: SessionManager
) : AuthRepository {

    override suspend fun login(
        rut: String,
        password: String
    ): LoginResponseDto {

        return try {

            val response = authApiService.login(
                LoginRequestDto(
                    RUT = rut,
                    password = password
                )
            )

            sessionManager.saveLogin(response)

            response

        } catch (e: Exception) {
            Log.e("AuthRepository", "Error al iniciar sesión: ${e.message}", e)
            throw e
        }
    }

    override suspend fun logout() {

        try {

            authApiService.logout()

        } finally {
            // Eliminar sesión aunque falle el endpoint
            sessionManager.logout()
        }
    }
}