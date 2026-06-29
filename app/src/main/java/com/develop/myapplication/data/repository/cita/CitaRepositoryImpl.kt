package com.develop.myapplication.data.repository.cita

import android.util.Log
import com.develop.myapplication.data.local.AppDatabase
import com.develop.myapplication.data.local.entity.CitaEntity
import com.develop.myapplication.data.remote.dto.CitaCreateDto
import com.develop.myapplication.data.remote.dto.CitaDto
import com.develop.myapplication.data.remote.service.CitaApiService
import com.develop.myapplication.data.repository.cita.CitaRepository
import com.develop.myapplication.ui.model.Cita
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CitaRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiService: CitaApiService
) : CitaRepository {

    override fun obtenerTodosCitas(): Flow<List<Cita>> {
        return database.citaDao().obtenerTodos().map { it.map { entidad -> entidad.toDomain() } }
    }

    override suspend fun insertarCita(cita: Cita) {
        database.citaDao().insertarTodos(cita.toEntity())
    }

    override suspend fun obtenerPorId(id: Int): Cita? {
        return database.citaDao().obtenerPorId(id)?.toDomain()
    }

    override suspend fun obtenerPorId(citaIds: IntArray): List<Cita> {
        return database.citaDao().obtenerPorId(citaIds).map { citaEntity -> citaEntity.toDomain() }
    }

    override suspend fun obtenerPorIdBackend(id: Int): Cita? {
        return try {
            val citaApi = apiService.getCitaById(id)
            database.citaDao().insertarTodos(citaApi.toEntity())
            citaApi.toDomain()
        } catch (e: Exception) {
            Log.e("CitaRepository", "Error al obtener la cita $id desde la API " + e.message, e)
            null
        }
    }

    override suspend fun insertarCitaBackend(cita: Cita) {
        try {
            val citaApi = apiService.createCita(cita.toCreateDto())
            database.citaDao().insertarTodos(citaApi.toEntity())
        } catch (e: Exception) {
            Log.e("CitaRepository", "Error al conectar con la base de datos." + e.message, e)
        }
    }

    override suspend fun actualizarCitaBackend(cita: Cita): Cita? {
        return try {
            val citaApi = apiService.updateCita(cita.id, cita.toCreateDto())
            database.citaDao().insertarTodos(citaApi.toEntity())
            citaApi.toDomain()
        } catch (e: Exception) {
            Log.e("CitaRepository", "Error al actualizar la cita ${cita.id} " + e.message, e)
            null
        }
    }

    override suspend fun borrarCita(cita: Cita) {
        database.citaDao().borrar(cita.toEntity())
    }

    override suspend fun borrarCitaBackend(cita: Cita) {
        try {
            database.citaDao().borrar(cita.toEntity())
            apiService.deleteCita(cita.id)
        } catch (e: Exception) {
            Log.e("CitaRepository", "Error al borrar la cita ${cita.id} desde la api " + e.message, e)
        }
    }

    override suspend fun sincronizarCitas() {
        try {
            val citasRemotas = apiService.getCitas()
            val entidades = citasRemotas.map { it.toEntity() }
            database.citaDao().refrescarCitas(entidades)
        } catch (e: Exception) {
            Log.e("CitaRepository", "Error al sincronizar Citas desde la API " + e.message, e)
        }
    }
}

fun CitaEntity.toDomain() = Cita(
    id = this.id,
    fecha = this.fecha ?: "Sin Fecha",
    detalle = this.detalle ?: "Sin detalle",
    conclusion = this.conclusion?.toString() ?: "Sin conclusión",
    idPaciente = this.idPaciente ?: 0,
    idHorarioHora = this.idHorarioHora ?: 0,
    idMedico = this.idMedico ?: -1
)

fun Cita.toEntity() = CitaEntity(
    id = this.id,
    fecha = this.fecha,
    detalle = this.detalle,
    conclusion = this.conclusion.toIntOrNull() ?: 0,
    idPaciente = this.idPaciente,
    idHorarioHora = this.idHorarioHora,
    idMedico = this.idMedico
)

fun Cita.toCreateDto(): CitaCreateDto {
    return CitaCreateDto(
        fecha = this.fecha,
        detalles = this.detalle,
        conclusiones = this.conclusion.toIntOrNull() ?: 0,
        horarioHoraId = this.idHorarioHora,
        pacienteId = this.idPaciente
    )
}

fun CitaDto.toEntity(): CitaEntity {
    return CitaEntity(
        id = this.id,
        fecha = this.fecha,
        detalle = this.detalles,
        conclusion = this.conclusiones,
        idPaciente = this.pacienteId,
        idHorarioHora = this.horarioHoraId,
        idMedico = this.horarioHora?.medicoId
    )
}

fun CitaDto.toDomain(): Cita {
    return Cita(
        id = this.id,
        fecha = this.fecha ?: "Sin Fecha",
        detalle = this.detalles ?: "Sin detalle",
        conclusion = this.conclusiones?.toString() ?: "Sin conclusión",
        idPaciente = this.pacienteId,
        idHorarioHora = this.horarioHoraId,
        idMedico = this.horarioHora?.medicoId ?: -1
    )
}