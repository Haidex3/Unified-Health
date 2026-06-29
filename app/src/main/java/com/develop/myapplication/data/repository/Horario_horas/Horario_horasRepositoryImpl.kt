package com.develop.myapplication.data.repository.Horario_horas

import android.util.Log
import com.develop.myapplication.data.local.AppDatabase
import com.develop.myapplication.data.local.entity.Horario_horasEntity
import com.develop.myapplication.data.remote.dto.Horario_horasCreate
import com.develop.myapplication.data.remote.dto.Horario_horasDto
import com.develop.myapplication.data.remote.service.Horario_horasApiService

import com.develop.myapplication.ui.model.Horario_horas
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.collections.map

class Horario_horasRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiService: Horario_horasApiService
): Horario_horasRepository {
    override fun obtenerTodosHorarios(): Flow<List<Horario_horas>> {
        return database.horario_horasDao().obtenerTodos().map{it.map{it.toDomain()}}
    }

    override suspend fun insertarHorario(horario_horas: Horario_horas) {
        database.horario_horasDao().insertarTodos(horario_horas.toEntity())
    }

    override suspend fun obtenerPorId(id: Int): Horario_horas? {
        return database.horario_horasDao().obtenerPorId(id)?.toDomain()
    }

    override suspend fun obtenerPorId(horarioIds: IntArray): List<Horario_horas> {
        return database.horario_horasDao().obtenerPorId(horarioIds).map{horario_horasEntity -> horario_horasEntity.toDomain()}
    }

    override suspend fun insertarHorarioBackend(horario: Horario_horas) {
        try {
            val horarioApi = apiService.createHorario(horario.toCreateDto())
            database.horario_horasDao().insertarTodos(horarioApi.toEntity())
        }catch (e: Exception){
            Log.e("Fallo","Error al conectar con la base de datos."+e.message,e)
        }
    }

    override suspend fun borrar(horario: Horario_horas) {
        return database.horario_horasDao().borrar(horario.toEntity())
    }

    override suspend fun sincronizarHorarios() {
        try {
            val horarioRemotos = apiService.getHorario()
            val entidades = horarioRemotos.map { it.toEntity() }
            database.horario_horasDao().refrescarHorarios(entidades)
        } catch (e: Exception) {
            Log.e("HospitalRepository", "Error al sincronizar Hospitales desde la API " + e.message, e)
        }
    }
    }


fun Horario_horasEntity.toDomain() = Horario_horas(
    id = this.id,
    hora = this.hora,
    disponible = this.disponible,
    fecha = this.fecha,
    medico_id = this.medico_id
)

fun Horario_horas.toEntity() = Horario_horasEntity(
    id = this.id,
    hora = this.hora,
    disponible = this.disponible,
    fecha = this.fecha,
    medico_id = this.medico_id
)

fun Horario_horas.toCreateDto(): Horario_horasCreate {
    return Horario_horasCreate(
        hora = this.hora,
        disponible = this.disponible,
        fecha = this.fecha,
        medico_id = this.medico_id
    )
}

fun Horario_horas.toDto(): Horario_horasDto {
    return Horario_horasDto(
        id = this.id,
        hora = this.hora,
        disponible = this.disponible,
        fecha = this.fecha,
        medico_id = this.medico_id
    )
}

fun Horario_horasDto.toEntity(): Horario_horasEntity{
    return Horario_horasEntity(
        id = this.id,
        hora = this.hora,
        disponible = this.disponible,
        fecha = this.fecha,
        medico_id = this.medico_id
    )
}

