package com.develop.myapplication.data.repository.horarioHora

import com.develop.myapplication.data.local.entity.HorarioHoraEntity
import com.develop.myapplication.ui.model.HorarioHora
import kotlinx.coroutines.flow.Flow


interface HorarioHoraRepository {

    fun obtenerTodosHorarios(): Flow<List<HorarioHora>>
    suspend fun obtenerPorId(id: Int): HorarioHora?
    suspend fun obtenerPorId(horarioIds: IntArray): List<HorarioHora>
    suspend fun insertarHorario( horario: HorarioHora)
    suspend fun borrar(horario: HorarioHora)
    suspend fun insertarHorarioBackend(horario: HorarioHora)
    suspend fun sincronizarHorarios()
}
