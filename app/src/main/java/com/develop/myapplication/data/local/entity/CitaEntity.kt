package com.develop.myapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class CitaEntity (
    @PrimaryKey val id: Int,

    @ColumnInfo(name = "fecha") val fecha: String?,
    @ColumnInfo(name = "detalles") val detalle: String?,
    @ColumnInfo(name = "conclusion") val conclusion: String?,

    @ColumnInfo val idPaciente:Int?
)