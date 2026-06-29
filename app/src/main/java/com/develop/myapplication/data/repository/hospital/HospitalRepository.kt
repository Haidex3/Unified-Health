package com.develop.myapplication.data.repository.hospital

import com.develop.myapplication.ui.model.Hospital
import kotlinx.coroutines.flow.Flow

interface HospitalRepository {
    fun obtenerTodosHospitales(): Flow<List<Hospital>>
    suspend fun obtenerPorId(id: Int): Hospital?
    suspend fun obtenerPorId(hospitalesIds: IntArray): List<Hospital>
    suspend fun buscarPorNombre(nombreBusqueda: String): Hospital
    suspend fun insertarHospital(hospital: Hospital)
    suspend fun borrarHospital(hospital: Hospital)
    suspend fun insertarHospitalBackend(hospital: Hospital)
    suspend fun sincronizarHospitales()
    fun buscarIdPorNombre(nombre: String): String
}