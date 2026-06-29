package com.develop.myapplication.data.repository.cita

import com.develop.myapplication.ui.model.Cita
import kotlinx.coroutines.flow.Flow

interface CitaRepository {

    fun obtenerTodosCitas(): Flow<List<Cita>>
    suspend fun obtenerPorId(id: Int): Cita?
    suspend fun obtenerPorId(citaIds: IntArray): List<Cita>
    suspend fun insertarCita(cita: Cita)
    suspend fun borrarCita(cita: Cita)
    suspend fun insertarCitaBackend(cita: Cita)
    suspend fun actualizarCitaBackend(cita: Cita): Cita?
    suspend fun borrarCitaBackend(cita: Cita)

    suspend fun sincronizarCitas()
}