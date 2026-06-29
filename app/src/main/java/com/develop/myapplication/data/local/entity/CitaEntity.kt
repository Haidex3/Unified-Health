package com.develop.myapplication.data.local.entity

import androidx.navigation.Navigator
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class CitaEntity (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "fecha") val fecha: String?,
    @ColumnInfo(name = "detalles") val detalle: String?,
    @ColumnInfo(name = "conclusion") val conclusion: Int?,
    @ColumnInfo(name = "idPaciente") val idPaciente: Int?,
    @ColumnInfo(name = "idHorarioHora") val idHorarioHora: Int?,
    @ColumnInfo(name = "idMedico") val idMedico: Int?
)