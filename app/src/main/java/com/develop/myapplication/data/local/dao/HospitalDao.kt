package com.develop.myapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.develop.myapplication.data.local.entity.HospitalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HospitalDao {
    //Obtiene todos los Hospitales de la tabla
    @Query("SELECT * FROM HospitalEntity")
    fun obtenerTodos(): Flow<List<HospitalEntity>>

    //Obtiene un Hospital por su ID
    @Query("SELECT * FROM HospitalEntity WHERE id = :id")
    suspend fun obtenerPorId(id: Int): HospitalEntity

    //Obtiene varios Hospital dentro de una lista de id's
    @Query("SELECT * FROM HospitalEntity WHERE id IN (:hospitalesIds)")
    suspend fun obtenerPorId(hospitalesIds: IntArray): List<HospitalEntity>

    //Obtiene un Hospital por su nombre
    @Query("SELECT * FROM HospitalEntity WHERE nombre = :nombreBusqueda LIMIT 1")
    suspend fun buscarPorNombre(nombreBusqueda: String): HospitalEntity

    //Inserta un Hospital
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTodos(vararg hospitales: HospitalEntity)

    //Borra un Hospital
    @Delete
    suspend fun borrar(hospital: HospitalEntity)

    @Query("DELETE FROM HospitalEntity")
    suspend fun borrarTodos()

    @Transaction
    suspend fun refrescarHospitales(hospitales: List<HospitalEntity>) {
        borrarTodos()
        insertarTodos(*hospitales.toTypedArray())
    }

}