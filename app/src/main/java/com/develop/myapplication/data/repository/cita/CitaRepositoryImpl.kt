package com.develop.myapplication.data.repository.cita



import android.util.Log
import com.develop.myapplication.data.local.AppDatabase
import com.develop.myapplication.data.local.entity.CitaEntity
import com.develop.myapplication.data.remote.dto.CitaCreateDto
import com.develop.myapplication.data.remote.dto.CitaDto
import com.develop.myapplication.data.remote.service.CitaApiService
import com.develop.myapplication.ui.model.Cita
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CitaRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiService: CitaApiService
): CitaRepository {
    override fun obtenerTodosCitas(): Flow<List<Cita>> {
        return database.citaDao().obtenerTodos().map { it.map { it.toDomain() } }
    }
    override suspend fun insertarCita(cita: Cita){
        database.citaDao().insertarTodos(cita.toEntity())
    }
    override suspend fun obtenerPorId(id: Int): Cita? {
        return database.citaDao().obtenerPorId(id)?.toDomain()
    }
    override suspend fun obtenerPorId(citasIds: IntArray): List<Cita> {
        return database.citaDao().obtenerPorId(citasIds).map { citaEntity -> citaEntity.toDomain() }
    }
    override suspend fun insertarCitaBackend(cita: Cita) {
        try {
            val citaApi = apiService.createCita(cita.toCreateDto())
            database.citaDao().insertarTodos(citaApi.toEntity())
        }catch (e: Exception){
            Log.e("Fallo","Error al conectar con la base de datos."+e.message,e)
        }
    }
    override suspend fun borrarCita(cita: Cita) {
        return database.citaDao().borrar(cita.toEntity())
    }

    override suspend fun sincronizarCitas() {
        try {
            val citasRemotos = apiService.getCitas()
            val entidades = citasRemotos.map { it.toEntity() }
            database.citaDao().refrescarCitas(entidades)
        } catch (e: Exception) {
            Log.e("CitaRepository", "Error al sincronizar Citas desde la API " + e.message, e)
        }
    }
}
fun CitaEntity.toDomain() = Cita(
    id = this.id,
    fecha = (this.fecha?: "Sin Fecha") as String,
    detalle = this.detalle?:"Sin detalle",
    conclusion = this.conclusion?:"Sin conclucion",
    idMedico = this.idMedico?:0
)

fun Cita.toEntity() = CitaEntity(
    id = this.id,
    fecha = this.fecha,
    detalle = this.detalle,
    conclusion = this.conclusion,
    idMedico = this.idMedico
)

fun Cita.toDto(): CitaDto {
    return CitaDto(
        id = this.id,
        fecha = this.fecha,
        detalle = this.detalle,
        conclusion= this.conclusion,
        idMedico = this.idMedico
    )
}

fun Cita.toCreateDto(): CitaCreateDto {
    return CitaCreateDto(
        fecha = this.fecha,
        detalle = this.detalle,
        conclusion = this.conclusion,
        idMedico = this.idMedico
    )
}

fun CitaDto.toEntity(): CitaEntity {

    return CitaEntity(
        id = this.id,
        fecha = this.fecha,
        detalle = this.detalle,
        conclusion = this.conclusion,
        idMedico = this.idMedico
    )
}