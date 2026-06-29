package com.develop.myapplication.data.remote.dto

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class CitaDto (
    val id: Int,
    @SerializedName("fecha") val fecha: String?,
    @SerializedName("detalles") val detalles: String?,
    @SerializedName("conclusiones") val conclusiones: Int?,
    @SerializedName("horario_hora_id") val horarioHoraId: Int,
    @SerializedName("paciente_id") val pacienteId: Int,
)