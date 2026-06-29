package com.develop.myapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CitaEntity (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "fecha") val fecha: String,
    @ColumnInfo(name = "detalles") val detalles: String,
    @ColumnInfo(name = "conclusiones") val conclusiones: String,
    @ColumnInfo(name = "IdMedico") val IdMedico: Int,
    @ColumnInfo(name = "IdPaciente") val IdPaciente: Int
)