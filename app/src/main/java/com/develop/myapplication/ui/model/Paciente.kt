package com.develop.myapplication.ui.model

import com.google.gson.annotations.SerializedName

data class Paciente(
    val id: Int,

    val nombre: String,
    val correo: String,
    val rut: Int,
    val sexo: String,
    val celular: String,
    val password: String,

    val idHospital: Int
)