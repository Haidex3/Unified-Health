package com.develop.myapplication.data.remote.dto

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class HorarioHoraCreateDto (
    @SerializedName("hora") val hora: String,
    @SerializedName("disponible") val disponible: Boolean,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("idMedico") val idMedico: Int,
)