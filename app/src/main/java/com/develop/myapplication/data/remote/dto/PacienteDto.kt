package com.develop.myapplication.data.remote.dto

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class PacienteDto(
    @PrimaryKey val id: Int,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("correo") val correo: String,
    @SerializedName("rut") val rut: String,
    @SerializedName("sexo") val sexo: String,
    @SerializedName("celular") val celular: Int,
    @SerializedName("password") val password: String,
    @SerializedName("idHospital") val idHospital: Int
)