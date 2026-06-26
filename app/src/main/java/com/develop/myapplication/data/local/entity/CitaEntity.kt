package com.develop.myapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.Date

data class CitaEntity (
    @PrimaryKey val idCita: Int,
    @ColumnInfo val date: Date,
    @ColumnInfo val detalles: String,
    @ColumnInfo val conclusiones: String,
    @ColumnInfo val idMedico:Int
)