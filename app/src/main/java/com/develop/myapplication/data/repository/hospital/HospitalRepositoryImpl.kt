package com.develop.myapplication.data.repository.hospital

import com.develop.myapplication.data.local.AppDatabase
import com.develop.myapplication.data.local.entity.HospitalEntity
import com.develop.myapplication.ui.model.Hospital
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HospitalRepositoryImpl @Inject constructor(
    private val database: AppDatabase
): HospitalRepository {
    override fun obtenerTodosHospitales(): Flow<List<Hospital>> {
        return database.hospitalDao().obtenerTodos().map { listaEntities ->
            listaEntities.map { hospitalEntity -> hospitalEntity.toDomain() }
        }
    }
    override suspend fun obtenerPorId(id: Int): Hospital? {
        return database.hospitalDao().obtenerPorId(id)?.toDomain()
    }
    override suspend fun obtenerPorId(hospitalesIds: IntArray): List<Hospital> {
        return database.hospitalDao().obtenerPorId(hospitalesIds).map { hospitalEntity -> hospitalEntity.toDomain() }
    }
    override suspend fun buscarPorNombre(nombreBusqueda: String): Hospital? {
        return database.hospitalDao().buscarPorNombre(nombreBusqueda)?.toDomain()
    }
    override suspend fun insertarHospital(hospital: Hospital) {
        database.hospitalDao().insertarTodos(hospital.toEntity())
    }
    override suspend fun borrarHospital(hospital: Hospital) {
        database.hospitalDao().borrar(hospital.toEntity())
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
