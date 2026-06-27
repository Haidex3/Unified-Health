package com.develop.myapplication.ui.model

data class Cita(
    val id: Int,
    val fecha: String,
    val detalle: String,
    val conclusion: String,
    val idPaciente: Int
)