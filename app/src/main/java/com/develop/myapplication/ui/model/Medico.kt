package com.develop.myapplication.ui.model
data class Medico(
    val id: Int? = null,

    val nombre: String,
    val correo: String,
    val celular: String,
    val password: String,

    val rut: Int,
    val idHospital: Int
)