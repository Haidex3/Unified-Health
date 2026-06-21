package com.develop.myapplication.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PacienteDto(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("apellido") val apellido: String,
    @SerializedName("RUT") val rut: String,
    @SerializedName("correo") val correo: String,
    @SerializedName("sexo") val sexo: String,
    @SerializedName("celular") val celular: String,
    @SerializedName("hospital_id") val hospital_id: Int
)