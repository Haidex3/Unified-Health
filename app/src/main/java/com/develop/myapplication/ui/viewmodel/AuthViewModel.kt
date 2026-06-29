package com.develop.myapplication.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    var rut by mutableStateOf("")
    var password by mutableStateOf("")

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var loginSuccess by mutableStateOf(false)
        private set

    fun login() {

        viewModelScope.launch {

            isLoading = true
            errorMessage = null
            loginSuccess = false

            try {

                val response = authRepository.login(
                    rut = rut,
                    password = password
                )

                loginSuccess = true

            } catch (e: Exception) {
                errorMessage = "RUT o contraseña incorrectos"
            } finally {
                isLoading = false
            }
        }
    }

    fun logout() {

        viewModelScope.launch {
            try {
                authRepository.logout()
            } catch (_: Exception) {
            }
        }
    }

    fun clearError() {
        errorMessage = null
    }
}