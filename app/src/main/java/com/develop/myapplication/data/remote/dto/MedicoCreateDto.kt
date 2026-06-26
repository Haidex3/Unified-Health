package com.develop.myapplication.data.remote.dto

import com.google.gson.annotations.SerializedName

class MedicoCreateDto (
    @SerializedName("nombre") val nombre: String,
    @SerializedName("correo") val correo: String,
    @SerializedName("RUT") val rut: String,
    @SerializedName("password") val password: String,
    @SerializedName("celular") val celular: Int,
    @SerializedName("hospital_id") val hospitalId: Int
)