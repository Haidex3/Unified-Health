package com.develop.myapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.Date

data class CitaEntity (
    @PrimaryKey val idCita: Int,

    @ColumnInfo(name = "fecha") val fecha: Date?,
    @ColumnInfo(name = "detalles") val detalles: String?,
    @ColumnInfo(name = "conclusiones") val conclusiones: String?,

    @ColumnInfo val idMedico:Int
)