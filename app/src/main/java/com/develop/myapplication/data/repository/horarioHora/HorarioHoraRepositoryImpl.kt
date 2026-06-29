package com.develop.myapplication.data.repository.horarioHora

import android.util.Log
import com.develop.myapplication.data.local.AppDatabase
import com.develop.myapplication.data.local.entity.HorarioHoraEntity
import com.develop.myapplication.data.repository.hospital.toCreateDto
import com.develop.myapplication.data.repository.hospital.toEntity
import com.develop.myapplication.ui.model.HorarioHora
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.collections.map


import com.develop.myapplication.ui.model.HorarioHora


class HorarioHoraRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiService: HorarioHoraApiService
): HorarioHoraRepositoryImpl {
    override fun obtenerTodosHorarios(): Flow<List<HorarioHora>> {
        return database.horarioHoraDao().obtenerTodos().map{it.map{it.toDomain()}}
    }

    override suspend fun insertarHorario(HorarioHora: HorarioHora) {
        database.horarioHoraDao().insertarTodos(HorarioHora.toEntity())
    }

    override suspend fun obtenerPorId(id: Int): HorarioHora? {
        return database.horarioHoraDao().obtenerPorId(id)?.toDomain()
    }

    override suspend fun obtenerPorId(horarioIds: IntArray): List<HorarioHora> {
        return database.horarioHoraDao().obtenerPorId(horarioIds).map{HorarioHoraEntity -> HorarioHoraEntity.toDomain()}
    }

    override suspend fun insertarHorarioBackend(horario: HorarioHora) {
        try {
            val horarioApi = apiService.createHorario(HorarioHora.toCreateDto())
            database.hospitalDao().insertarTodos(horarioApi.toEntity())
        }catch (e: Exception){
            Log.e("Fallo","Error al conectar con la base de datos."+e.message,e)
        }
    }


    override suspend fun borrar(horario: HorarioHora) {
        return database.horarioHoraDao().borrar(horario.toEntity())
    }

    override suspend fun sincronizarHorarios() {
        try {
            val horarioRemotos = apiService.getHorarioHora()
            val entidades = horarioRemotos.map { it.toEntity() }
            database.horarioHoraDao().refrescarHorarios(entidades)
        } catch (e: Exception) {
            Log.e("HospitalRepository", "Error al sincronizar Hospitales desde la API " + e.message, e)
        }
    }
}


fun HorarioHoraEntity.toDomain() = HorarioHora(
    id = this.id,
    hora = this.hora?:"Sin hora",
    disponible = this.disponible?:false,
    fecha = this.fecha?:"Sin fecha",
    idMedico = this.idMedico?: -1,
    idCita = this.idCita?:-1
)

fun HorarioHora.toEntity() = HorarioHoraEntity(
    id = this.id,
    hora = this.hora,
    disponible = this.disponible,
    fecha = this.fecha,
    idMedico = this.idMedico,
    idCita = this.idCita
)

fun HorarioHora.toCreateDto(): HorarioHoraCreateDto{
    return HorarioHoraCreateDto(
        id = this.id,
        hora = this.hora,
        disponible = this.disponible,
        fecha = this.fecha,
        idMedic = this.idMedico,
        idCita  = this.idCita
    )
}

fun HorarioHora.toDto(): HorarioHoraDto{
    return HorarioHoraDto(
        id = this.id,
        hora = this.hora,
        disponible = this.disponible,
        fecha = this.fecha,
        idMedico = this.idMedico,
        idCita = this.idCita
    )
}