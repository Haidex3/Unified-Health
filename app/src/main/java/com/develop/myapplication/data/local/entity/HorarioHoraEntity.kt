package com.develop.myapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HorarioHoraEntity(
    @PrimaryKey val id:Int,

    @ColumnInfo(name = "hora") val hora: String?,
    @ColumnInfo val disponible: Boolean?,
    @ColumnInfo(name = "fecha") val fecha: String?,

    @ColumnInfo val idCita: Int?,
    @ColumnInfo val idMedico: Int?
)