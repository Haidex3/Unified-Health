package com.develop.myapplication.data.repository.hospital

import android.util.Log
import com.develop.myapplication.data.local.AppDatabase
import com.develop.myapplication.data.local.entity.HospitalEntity
import com.develop.myapplication.data.remote.dto.HospitalCreateDto
import com.develop.myapplication.data.remote.dto.HospitalDto
import com.develop.myapplication.data.remote.service.HospitalApiService
import com.develop.myapplication.data.repository.hospital.HospitalRepository
import com.develop.myapplication.ui.model.Hospital
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HospitalRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiService: HospitalApiService
): HospitalRepository {
    override fun obtenerTodosHospitales(): Flow<List<Hospital>> {
        return database.hospitalDao().obtenerTodos().map { it.map { it.toDomain() } }
    }
    override suspend fun insertarHospital(hospital: Hospital){
        database.hospitalDao().insertarTodos(hospital.toEntity())
    }
    override suspend fun obtenerPorId(id: Int): Hospital? {
        return database.hospitalDao().obtenerPorId(id)?.toDomain()
    }
    override suspend fun obtenerPorId(hospitalesIds: IntArray): List<Hospital> {
        return database.hospitalDao().obtenerPorId(hospitalesIds).map { hospitalEntity -> hospitalEntity.toDomain() }
    }
    override suspend fun buscarPorNombre(nombreBusqueda: String): Hospital {
        return database.hospitalDao().buscarPorNombre(nombreBusqueda).toDomain()
    }
    override suspend fun insertarHospitalBackend(hospital: Hospital) {
        try {
            val hospitalApi = apiService.createHospital(hospital.toCreateDto())
            database.hospitalDao().insertarTodos(hospitalApi.toEntity())
        }catch (e: Exception){
            Log.e("Fallo","Error al conectar con la base de datos."+e.message,e)
            }
        }
    override suspend fun borrarHospital(hospital: Hospital) {
        try {
            database.hospitalDao().borrar(hospital.toEntity())
            apiService.deleteHospital(hospital.id)
        }catch (e: Exception){
            Log.e("HospitalRepository","Error al borrar el hospiradl desde la api"+e.message, e)
        }

    }

    override suspend fun sincronizarHospitales() {
        try {
            val hospitalesRemotos = apiService.getHospital()
            val entidades = hospitalesRemotos.map { it.toEntity() }
            database.hospitalDao().refrescarHospitales(entidades)
        } catch (e: Exception) {
            Log.e("HospitalRepository", "Error al sincronizar Hospitales desde la API " + e.message, e)
        }
    }
    override fun buscarIdPorNombre(nombre: String): String
    {
        return database.hospitalDao().buscarIdPorNombre(nombre).toString()
    }
}
fun HospitalEntity.toDomain() = Hospital(
    id = this.id,
    nombre = this.nombre ?: "Sin nombre",
    correo = this.correo ?: "Sin correo",
    telefono = this.telefono ?: 0,
    ubicacion = this.ubicacion ?: "Sin ubicación"
)

fun Hospital.toEntity() = HospitalEntity(
    id = this.id,
    nombre = this.nombre,
    correo = this.correo,
    telefono = this.telefono,
    ubicacion = this.ubicacion
)

fun Hospital.toDto(): HospitalDto {
    return HospitalDto(
        id = this.id,
        nombre = this.nombre,
        correo = this.correo,
        telefono = this.telefono,
        ubicacion = this.ubicacion
    )
}

fun Hospital.toCreateDto(): HospitalCreateDto {
    return HospitalCreateDto(
        nombre = this.nombre,
        correo = this.correo,
        telefono = this.telefono,
        ubicacion = this.ubicacion
    )
}

fun HospitalDto.toEntity(): HospitalEntity {

    return HospitalEntity(
        id = this.id,
        nombre = this.nombre,
        correo = this.correo,
        telefono = this.telefono,
        ubicacion = this.ubicacion
    )
}