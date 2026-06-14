package com.develop.myapplication.data.remote.dto

import com.google.gson.annotations.SerializedName

data class HospitalDto(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("correo") val correo: String,
    @SerializedName("telefono") val telefono: Int,
    @SerializedName("ubicacion") val ubicacion: String
)