package com.develop.myapplication.data.repository.Horario_horas

import com.develop.myapplication.data.local.entity.Horario_horasEntity
import com.develop.myapplication.ui.model.Horario_horas
import kotlinx.coroutines.flow.Flow


interface Horario_horasRepository {

    fun obtenerTodosHorarios(): Flow<List<Horario_horas>>
    suspend fun obtenerPorId(id: Int): Horario_horas?
    suspend fun obtenerPorId(horarioIds: IntArray): List<Horario_horas>
    suspend fun insertarHorario( horario: Horario_horas)
    suspend fun borrar(horario: Horario_horas)
    suspend fun insertarHorarioBackend(horario: Horario_horas)
    suspend fun sincronizarHorarios()
}

