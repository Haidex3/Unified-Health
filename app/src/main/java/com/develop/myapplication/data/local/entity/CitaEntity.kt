package com.develop.myapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class CitaEntity (
    @PrimaryKey val idCita: Int,

    @ColumnInfo(name = "fecha") val fecha: String?,
    @ColumnInfo(name = "detalles") val detalles: String?,
    @ColumnInfo(name = "conclusiones") val conclusiones: String?,

    @ColumnInfo val idMedico: Int,
    val id: Int,
    val detalle: String?,
    val conclusion: String?
) {
    val id: Int
    val detalle: String
    val conclusion: String
}