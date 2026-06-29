package com.develop.myapplication.data.repository.horarioHora

import com.develop.myapplication.data.remote.service.HorarioHoraApiService
import kotlinx.coroutines.flow.Flow


interface HorarioHoraRepository {

    fun obtenerTodosHorarios(): Flow<List<HorarioHoraApiService>>
    suspend fun obtenerPorId(id: Int): HorarioHoraApiService?
    suspend fun obtenerPorId(horarioIds: IntArray): List<HorarioHoraApiService>
    suspend fun insertarHorario( horario: HorarioHoraApiService)
    suspend fun borrar(horario: HorarioHoraApiService)
    suspend fun insertarHorarioBackend(horario: HorarioHoraApiService)
    suspend fun sincronizarHorarios()
}