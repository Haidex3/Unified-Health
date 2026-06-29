package com.develop.myapplication.ui.model

import androidx.room.ColumnInfo

data class Cita (
    val id: Int,
    val fecha: String,
    val detalles: String,
    val conclusiones: String,
    val IdMedico: Int,
    val IdPaciente: Int
)