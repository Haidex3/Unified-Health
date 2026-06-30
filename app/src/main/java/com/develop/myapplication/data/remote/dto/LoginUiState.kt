package com.develop.myapplication.data.remote.dto

data class LoginUiState(
    val isLoading: Boolean = false,
    val loginResponse: LoginResponseDto? = null,
    val error: String? = null
)