package com.develop.myapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class PacienteEntity(
    @PrimaryKey val id: Int,
    @SerializedName("nombre") val nombre: String?,
    @SerializedName("correo") val correo: String?,
    @SerializedName("RUT") val RUT: String?,
    @SerializedName("sexo") val sexo: String?,
    @SerializedName("celular") val celular: Int?,
    @SerializedName("password") val password: String?,
    @SerializedName("hospital_id") val hospitalId: Int?
)