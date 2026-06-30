package com.develop.myapplication.ui.model

data class HorarioHora(
    val id:Int,
    val hora: String,
    val fecha: String,
    val disponible: Boolean,
    val idMedico: Int
)