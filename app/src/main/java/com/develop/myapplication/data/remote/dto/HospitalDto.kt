package com.develop.myapplication.data.remote.dto

import com.google.gson.annotations.SerializedName

data class HospitalDto(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("correo") val correo: String,
    @SerializedName("telefono") val telefono: String,
    @SerializedName("ubicacion") val ubicacion: String

)