package com.develop.myapplication.data.remote.dto

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class HorarioHoraDto(
    @PrimaryKey val id : Int,
    @SerializedName("hora") val hora: String,
    @SerializedName("disponible") val disponible: Boolean,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("idMedico") val idMedico: Int,
    @SerializedName("idCita") val idCita: Int
)