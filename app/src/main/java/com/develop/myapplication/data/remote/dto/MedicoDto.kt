package com.develop.myapplication.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MedicoDto(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("correo") val correo: String,
    @SerializedName("RUT") val rut: String,
    @SerializedName("contraseña") val contrasena: String,
    @SerializedName("celular") val celular: Int,
    @SerializedName("hospital_id") val hospitalId: Int
)