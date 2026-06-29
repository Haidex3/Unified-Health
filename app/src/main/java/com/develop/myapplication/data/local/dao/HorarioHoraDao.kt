package com.develop.myapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import com.develop.myapplication.data.local.entity.HorarioHoraEntity

@Dao
interface HorarioHoraDao {
    @Query ("SELECT * FROM HorarioHoraEntity")
    fun obtenerTodos(): Flow<List<HorarioHoraEntity>>

    @Query("SELECT * FROM HorarioHoraEntity WHERE id = :id")
    suspend fun obtenerPorId(id: Int): HorarioHoraEntity

    @Query("SELECT * FROM HorarioHoraEntity WHERE id IN (:horarioIds)")
    suspend fun obtenerPorId(horarioIds: IntArray): List<HorarioHoraEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTodos(vararg horario: HorarioHoraEntity)

    @Delete
    suspend fun borrar(horario: HorarioHoraEntity)

    @Query("DELETE FROM HorarioHoraEntity")
    suspend fun borrarTodos()

    @Transaction
    suspend fun refrescarHorarios(horarios: List<HorarioHoraEntity>) {
        borrarTodos()
        insertarTodos(*horarios.toTypedArray())
    }


}