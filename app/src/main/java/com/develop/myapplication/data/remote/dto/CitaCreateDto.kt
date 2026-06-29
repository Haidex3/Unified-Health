package com.develop.myapplication.data.remote.dto


import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class CitaCreateDto (
    @SerializedName("fecha") val fecha: String?,
    @SerializedName("detalles") val detalle: String?,
    @SerializedName("conclusion") val conclusion: String?,
    @SerializedName("idMedico") val idMedico:Int?
)