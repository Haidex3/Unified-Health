package com.develop.myapplication.data.remote.dto

import com.google.gson.annotations.SerializedName

class MedicoCreateDto (
    @SerializedName("nombre") val nombre: String,
    @SerializedName("correo") val correo: String,
    @SerializedName("rut") val rut: Int,
    @SerializedName("password") val password: String,
    @SerializedName("celular") val celular: String,
    @SerializedName("idHospital") val idHospital: Int
)