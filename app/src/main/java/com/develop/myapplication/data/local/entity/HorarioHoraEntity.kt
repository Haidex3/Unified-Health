package com.develop.myapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.Date

data class HorarioHoraEntity(
    @PrimaryKey val idHorarioHora:Int,
    @ColumnInfo val time: String,
    @ColumnInfo val disponible: Boolean,
    @ColumnInfo val fecha: Date,
    @ColumnInfo val idCita: Int,
    @ColumnInfo val idMedico: Int
)