package com.develop.myapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.develop.myapplication.data.local.entity.Horario_horasEntity
import com.develop.myapplication.data.local.entity.HospitalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface Horario_horasDao {
    @Query ("SELECT * FROM Horario_horasEntity")
    fun obtenerTodos(): Flow<List<Horario_horasEntity>>

    @Query("SELECT * FROM Horario_horasEntity WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Horario_horasEntity

    @Query("SELECT * FROM Horario_horasEntity WHERE id IN (:horarioIds)")
    suspend fun obtenerPorId(horarioIds: IntArray): List<Horario_horasEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTodos(vararg horario: Horario_horasEntity)

    @Delete
    suspend fun borrar(horario: Horario_horasEntity)

    @Query("DELETE FROM Horario_horasEntity")
    suspend fun borrarTodos()

    @Transaction
    suspend fun refrescarHorarios(horarios: List<Horario_horasEntity>) {
        borrarTodos()
        insertarTodos(*horarios.toTypedArray())
    }


}