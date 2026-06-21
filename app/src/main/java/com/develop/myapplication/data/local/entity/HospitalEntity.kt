package com.develop.myapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HospitalEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "correo") val correo: String?,
    @ColumnInfo(name = "telefono") val telefono: Int?,
    @ColumnInfo(name = "ubicacion") val ubicacion: String?
)