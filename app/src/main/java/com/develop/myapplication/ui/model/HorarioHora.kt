package com.develop.myapplication.ui.model

data class HorarioHora(
    val id:Int,
    val hora: String,
    val disponible: Boolean,
    val fecha: String,
    val idCita: Int,
    val idMedico: Int
)