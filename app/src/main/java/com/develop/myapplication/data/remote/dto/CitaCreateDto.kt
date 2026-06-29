package com.develop.myapplication.data.remote.dto
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class CitaCreateDto (
    @SerializedName(value = "fecha") val fecha: String,
    @SerializedName(value = "detalles") val detalles: String,
    @SerializedName(value = "conclusiones") val conclusiones: String,
    @SerializedName(value = "IdMedico") val IdMedico: Int,
    @SerializedName(value = "IdPaciente") val IdPaciente: Int
)