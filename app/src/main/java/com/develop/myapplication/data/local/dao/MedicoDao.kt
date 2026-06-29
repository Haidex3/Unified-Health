package com.develop.myapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.develop.myapplication.data.local.entity.MedicoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicoDao {
    @Query("SELECT * FROM MedicoEntity")
    fun obtenerTodos(): Flow<List<MedicoEntity>>

    @Query("SELECT * FROM MedicoEntity WHERE id = :id")
    suspend fun obtenerPorId(id: Int): MedicoEntity

    @Query("SELECT * FROM MedicoEntity WHERE id IN (:medicosID)")
    suspend fun obtenerPorId(medicosID: IntArray): List<MedicoEntity>

    @Query("SELECT * FROM MedicoEntity WHERE nombre = :nombreBusqueda LIMIT 1")
    suspend fun buscarPorNombre(nombreBusqueda: String): MedicoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTodos(vararg medicos: MedicoEntity)

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