package com.develop.myapplication.data.local.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Horario_horasEntity(
    @PrimaryKey val id : Int?,
    @ColumnInfo(name = "hora") val hora: String,
    @ColumnInfo(name= "disponible") val disponible: Boolean,
    @ColumnInfo(name = "fecha") val fecha: String,
    @ColumnInfo(name = "medico_id") val medico_id: String
)
