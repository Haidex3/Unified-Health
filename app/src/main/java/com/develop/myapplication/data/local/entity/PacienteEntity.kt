package com.develop.myapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class PacienteEntity(
    @PrimaryKey val idPaciente: Int,
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "correo") val corre: String?,
    @ColumnInfo val rut: Int?,
    @ColumnInfo val sexo: Boolean?,
    @ColumnInfo(name = "celular") val celular: String?,
    @ColumnInfo(name = "password") val password: String?,

    @ColumnInfo val idHospital: Int
)