package com.develop.myapplication.ui.model

data class Cita(
    val id: Int,
    val fecha: String,
    val detalle: String,
    val conclusiones: String,
    val idHorarioHora: Int,
    val idPaciente: Int
)