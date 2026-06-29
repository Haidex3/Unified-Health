package com.develop.myapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.develop.myapplication.data.local.entity.CitaEntity
import com.develop.myapplication.data.local.entity.HospitalEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface CitaDao {
    @Query("SELECT * FROM CitaEntity")
    fun obtenerTodos(): Flow<List<CitaEntity>>

    @Query("SELECT * FROM CitaEntity WHERE id = :id")
    suspend fun obtenerPorId(id: Int): CitaEntity

    //Obtiene varios Hospital dentro de una lista de id's
    @Query("SELECT * FROM CitaEntity WHERE id IN (:citaIds)")
    suspend fun obtenerPorId(citaIds: IntArray): List<CitaEntity>

    //Inserta un Hospital
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTodos(vararg citas: CitaEntity)

    //Borra un Hospital
    @Delete
    suspend fun borrar(cita: CitaEntity)

    @Query("DELETE FROM CitaEntity")
    suspend fun borrarTodos()

    @Transaction
    suspend fun refrescarCitas(citas: List<CitaEntity>) {
        borrarTodos()
        insertarTodos(*citas.toTypedArray())
    }


}