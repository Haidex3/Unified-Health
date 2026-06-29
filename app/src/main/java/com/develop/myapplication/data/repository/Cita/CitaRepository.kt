package com.develop.myapplication.data.repository.Cita

import com.develop.myapplication.ui.model.Cita
import kotlinx.coroutines.flow.Flow

interface CitaRepository {
    fun obtenerTodosCitas(): Flow<List<Cita>>
    suspend fun obtenerPorId(id: Int): Cita?
    suspend fun obtenerPorId(CitaIds: IntArray): List<Cita>
    suspend fun insertarCita(Cita: Cita)
    suspend fun borrarCita(Cita: Cita)
    suspend fun insertarCitaBackend(Cita: Cita)
    suspend fun sincronizarCitas()
}