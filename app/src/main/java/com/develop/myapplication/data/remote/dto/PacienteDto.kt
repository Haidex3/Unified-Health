package com.develop.myapplication.data.remote.dto

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class PacienteDto(
    @PrimaryKey val id : Int,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("RUT") val rut: String,
    @SerializedName("correo") val correo: String,
    @SerializedName("sexo") val sexo: String,
    @SerializedName("celular") val celular: String,
    @SerializedName("hospital_id") val hospitalId: Int
)