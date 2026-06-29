package com.develop.myapplication.data.repository.Cita

import com.develop.myapplication.data.local.entity.CitaEntity
import com.develop.myapplication.ui.model.Cita
import com.develop.myapplication.ui.model.Hospital
import kotlinx.coroutines.flow.Flow


/*
    fun obtenerTodos(): Flow<List<CitaEntity>>
    suspend fun obtenerPorId(id: Int): CitaEntity
    suspend fun obtenerPorId(citaIds: IntArray): List<CitaEntity>
    suspend fun insertarTodos(vararg citas: CitaEntity)
    suspend fun borrar(cita: CitaEntity)
    suspend fun borrarTodos()
    suspend fun refrescarHospitales(citas: List<CitaEntity>) {
        borrarTodos()
        insertarTodos(*citas.toTypedArray())
    }
*/

interface CitaRepository {
    fun obtenerTodos(): Flow<List<Cita>>
    suspend fun obtenerPorId(id: Int): Cita?
    suspend fun obtenerPorId(citaIds: IntArray): List<Cita>
    suspend fun insertarCita(cita: Cita)
    suspend fun insertarCitaBackend(cita: Cita)
    suspend fun borrarCita(cita: Cita)
    suspend fun sincronizarCita()
}
