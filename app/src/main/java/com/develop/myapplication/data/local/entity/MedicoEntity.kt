package com.develop.myapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class MedicoEntity(
    @PrimaryKey val idMedico: Int,
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "correo") val correo: String?,
    @ColumnInfo(name = "celular") val celular: String?,
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo val rut: Int?,

    @ColumnInfo val idHospital: Int
    )