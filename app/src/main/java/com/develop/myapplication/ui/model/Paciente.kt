package com.develop.myapplication.ui.model

import com.google.gson.annotations.SerializedName

data class Paciente(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("apellido") val apellido: String,
    @SerializedName("rut") val rut: String,
    @SerializedName("correo") val correo: String,
    @SerializedName("sexo") val sexo: String,
    @SerializedName("num_celular") val num_celular: String
)