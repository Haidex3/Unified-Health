package com.develop.myapplication.data.repository.Horario_horas

import com.develop.myapplication.data.local.entity.Horario_horasEntity
import com.develop.myapplication.ui.model.Horario_horas
import kotlinx.coroutines.flow.Flow


interface Horario_horasRepository {

    fun obtenerTodos(): Flow<List<Horario_horasEntity>>?
    suspend fun obtenerPorId(id: Int): Horario_horasEntity?
    suspend fun obtenerPorId(userIds: IntArray): List<Horario_horasEntity>?
    suspend fun insertarTodos(vararg horario: Horario_horasEntity)
    suspend fun borrar(horario: Horario_horasEntity)

}