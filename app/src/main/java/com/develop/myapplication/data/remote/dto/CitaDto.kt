package com.develop.myapplication.data.remote.dto

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class CitaDto (
    @PrimaryKey val id: Int,
    @SerializedName("fecha")            val fecha: String?,
    @SerializedName("detalles")         val detalle: String?,
    @SerializedName("conclusiones")     val conclusiones: String?,
    @SerializedName("hoario_hora_id")   val idHorarioHora: Int?,
    @SerializedName("paciente_id")       val idPaciente:Int?
)