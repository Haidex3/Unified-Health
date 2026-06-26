package com.develop.myapplication.ui.model

import com.google.gson.annotations.SerializedName

data class Paciente(
  val id: Int,
    val nombre : String,
    val correo : String,
    val RUT: String,
    val sexo: String,
    val celular: Int,
    val password: String,
    val hospitalId: Int
)