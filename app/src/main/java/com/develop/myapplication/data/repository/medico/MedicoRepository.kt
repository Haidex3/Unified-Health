package com.develop.myapplication.data.repository.medico

import com.develop.myapplication.ui.model.Medico
import kotlinx.coroutines.flow.Flow

interface MedicoRepository {
    fun obtenerTodosMedicos(): Flow<List<Medico>>

    suspend fun obtenerPorId(id: Int): Medico?

    suspend fun buscarPorNombre(nombreBusqeda: String): Medico?

    suspend fun insertarMedico(medico: Medico)

    suspend fun borrarMedico(medico: Medico)

    suspend fun insertarMedicoBackend(medico: Medico)

    suspend fun sincronizarMedicos()
}