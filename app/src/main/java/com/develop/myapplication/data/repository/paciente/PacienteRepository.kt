package com.develop.myapplication.data.repository.paciente

import com.develop.myapplication.ui.model.Paciente
import kotlinx.coroutines.flow.Flow

interface PacienteRepository {
    fun obtenerTodosPacientes(): Flow<List<Paciente>>

    suspend fun obtenerPorId(id: Int): Paciente?

    suspend fun buscarPorNombre(nombreBusqeda: String): Paciente?

    suspend fun insertarPaciente(paciente: Paciente)

    suspend fun borrarPaciente(paciente: Paciente)

    suspend fun insertarPacienteBackend(paciente: Paciente)

    suspend fun sincronizarPacientes()

    fun buscarPorRut(rut: Int):Paciente
}