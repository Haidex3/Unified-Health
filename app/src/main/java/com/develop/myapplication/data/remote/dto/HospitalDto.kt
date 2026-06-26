package com.develop.myapplication.data.remote.dto

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class HospitalDto(
    @PrimaryKey val id: Int,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("correo") val correo: String,
    @SerializedName("telefono") val telefono: Int,
    @SerializedName("ubicacion") val ubicacion: String
)