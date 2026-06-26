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
    //Obtiene todos los Pacientes de la tabla
    @Query("SELECT * FROM PacienteEntity")
    fun obtenerTodos(): Flow<List<PacienteEntity>>

    //Obtiene un Paciente por su ID
    @Query("SELECT * FROM PacienteEntity WHERE id = :id")
    suspend fun obtenerPorId(id: Int): PacienteEntity

    //Obtiene varios Pacientes dentro de una lista de id's
    @Query("SELECT * FROM PacienteEntity WHERE id IN (:pacientesIds)")
    suspend fun obtenerPorId(pacientesIds: IntArray): List<PacienteEntity>

    //Obtiene un Paciente por su nombre
    @Query("SELECT * FROM PacienteEntity WHERE nombre = :nombreBusqueda LIMIT 1")
    suspend fun buscarPorNombre(nombreBusqueda: String): PacienteEntity

    //Inserta un Paciente
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTodos(vararg pacientes: PacienteEntity)

    //Borra un Paciente
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
