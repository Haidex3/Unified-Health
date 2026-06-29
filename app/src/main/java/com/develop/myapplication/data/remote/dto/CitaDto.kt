package com.develop.myapplication.data.remote.dto
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class CitaDto (

    @PrimaryKey val id: Int,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("detalles") val detalles: String,
    @SerializedName("conclusiones") val conclusiones: String,
    @SerializedName(value = "IdMedico") val IdMedico: Int,
    @SerializedName(value = "IdPaciente") val IdPaciente: Int
)