package com.develop.myapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.develop.myapplication.data.local.entity.HospitalEntity
import com.develop.myapplication.data.local.entity.MedicoEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MedicoDao {
    //Obtiene todos los Medicos de la tabla
    @Query("SELECT * FROM MedicoEntity")
    fun obtenerTodos(): Flow<List<MedicoEntity>>

    //Obtiene un Medico por su ID
    @Query("SELECT * FROM MedicoEntity WHERE id = :id")
    suspend fun obtenerPorId(id: Int): MedicoEntity

    //Obtiene varios Medicos dentro de una lista de id's
    @Query("SELECT * FROM MedicoEntity WHERE id IN (:medicosIds)")
    suspend fun obtenerPorId(medicosIds: IntArray): List<MedicoEntity>

    //Obtiene un Medico por su nombre
    @Query("SELECT * FROM MedicoEntity WHERE nombre = :nombreBusqueda LIMIT 1")
    suspend fun buscarPorNombre(nombreBusqueda: String): MedicoEntity

    //Inserta un Medico
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTodos(vararg medicos: MedicoEntity)

    //Borra un Medico
    @Delete
    suspend fun borrar(medico: MedicoEntity)

    @Query("DELETE FROM MedicoEntity")
    suspend fun borrarTodos()

    @Transaction
    suspend fun refrescarMedicos(medicos: List<MedicoEntity>) {
        borrarTodos()
        insertarTodos(*medicos.toTypedArray())
    }

}
