package com.develop.myapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MedicoEntity(
    @PrimaryKey val id: Int,

    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "correo") val correo: String?,
    @ColumnInfo(name = "celular") val celular: String?,
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo(name = "RUT") val rut: Int?,
    @ColumnInfo(name = "hospital_id") val idHospital: Int?
    )