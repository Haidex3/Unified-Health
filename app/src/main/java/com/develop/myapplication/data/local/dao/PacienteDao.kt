package com.develop.myapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.develop.myapplication.data.local.entity.PacienteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PacienteDao {
    @Query("SELECT * FROM PacienteEntity")
    fun obtenerTodos(): Flow<List<PacienteEntity>>

    @Query("SELECT * FROM PacienteEntity WHERE id = :id")
    suspend fun obtenerPorId(id: Int): PacienteEntity

    @Query("SELECT * FROM PacienteEntity WHERE id IN (:pacientesId)")
    suspend fun obtenerPorId(pacientesId: IntArray): List<PacienteEntity>

    @Query("SELECT * FROM PacienteEntity WHERE nombre = :nombreBusqueda LIMIT 1")
    suspend fun buscarPorNombre(nombreBusqueda: String): PacienteEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTodos(vararg paacientes: PacienteEntity)

    @Delete
    suspend fun borrar(paciente: PacienteEntity)

    @Query("DELETE FROM PacienteEntity")
    suspend fun borrarTodos()

    @Transaction
    suspend fun refrescarPacientes(pacientes: List<PacienteEntity>) {
        borrarTodos()
        insertarTodos(*pacientes.toTypedArray())
    }

}