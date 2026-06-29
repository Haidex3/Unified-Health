package com.develop.myapplication.data.remote.dto

data class UserDto(
    val id: Int,
    val nombre: String,
    val correo: String,
    val RUT: String,
    val password: String,
    val celular: String,
    val hospital_id: Int,
    val created_at: String,
    val updated_at: String
)