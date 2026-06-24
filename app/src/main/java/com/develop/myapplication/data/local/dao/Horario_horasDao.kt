package com.develop.myapplication.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.develop.myapplication.data.local.entity.Horario_horasEntity
import kotlinx.coroutines.flow.Flow

interface Horario_horasDao {
    @Query ("SELECT * FROM Horario_horasEntity")
    fun obtenerTodos(): Flow<List<Horario_horasEntity>>?

    @Query("SELECT * FROM Horario_horasEntity WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Horario_horasEntity?

    @Query("SELECT * FROM Horario_horasEntity WHERE id IN (:userIds)")
    suspend fun obtenerPorId(userIds: IntArray): List<Horario_horasEntity>?

    @Insert
    suspend fun insertarTodos(vararg horario: Horario_horasEntity)

    @Delete
    suspend fun borrar(horario: Horario_horasEntity)

}