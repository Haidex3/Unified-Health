package com.develop.myapplication.data.remote.dto

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Horario_horasCreate (
    @SerializedName("hora") val hora: String,
    @SerializedName("disponible") val disponible: Boolean,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("medico_id") val medico_id: String
)