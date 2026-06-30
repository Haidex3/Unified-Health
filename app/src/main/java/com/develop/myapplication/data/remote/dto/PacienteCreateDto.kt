package com.develop.myapplication.data.remote.dto

import com.google.gson.annotations.SerializedName

class PacienteCreateDto(
    @SerializedName("nombre") val nombre: String,
    @SerializedName("correo") val correo: String,
    @SerializedName("RUT") val rut: Int,
    @SerializedName("sexo") val sexo: String,
    @SerializedName("celular") val celular: String,
    @SerializedName("password") val password: String,
    @SerializedName("hospital_id") val idHospital: Int
)