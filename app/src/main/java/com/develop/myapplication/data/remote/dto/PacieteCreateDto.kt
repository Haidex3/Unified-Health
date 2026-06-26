package com.develop.myapplication.data.remote.dto

import com.google.gson.annotations.SerializedName

class PacieteCreateDto(
    @SerializedName("nombre") val nombre: String,
    @SerializedName("correo") val correo: String,
    @SerializedName("RUT") val RUT: String,
    @SerializedName("sexo") val sexo: String,
    @SerializedName("celular") val celular: Int,
    @SerializedName("password") val password: String,
    @SerializedName("hospital_id") val hospitalId: Int
)