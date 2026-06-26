package com.develop.myapplication.data.repository.medico

import android.util.Log
import com.develop.myapplication.data.local.AppDatabase
import com.develop.myapplication.data.local.entity.MedicoEntity
import com.develop.myapplication.data.remote.dto.MedicoCreateDto
import com.develop.myapplication.data.remote.dto.MedicoDto
import com.develop.myapplication.data.remote.service.MedicoApiService
import com.develop.myapplication.ui.model.Medico
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MedicoRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiService: MedicoApiService
): MedicoRepository{
    override fun obtenerTodosMedicos(): Flow<List<Medico>> {
        return database.medicoDao().obtenerTodos().map { it.map { it.toDomain() } }
    }
    override suspend fun insertarMedico(medico: Medico) {
        database.medicoDao().insertarTodos(medico.toEntity())
    }
    override suspend fun obtenerPorId(id: Int): Medico? {
        return database.medicoDao().obtenerPorId(id)?.toDomain()
    }
    override suspend fun buscarPorNombre(nombreBusqeda: String): Medico? {
        return database.medicoDao().buscarPorNombre(nombreBusqeda)?.toDomain()
    }
    override suspend fun insertarMedicoBackend(medico: Medico) {
        try {
            val medicoApi = apiService.createMedico(medico.toCreateDto())
            database.medicoDao().insertarTodos(medicoApi.toEntity())
        }catch (e: Exception){
            Log.e("Fallo","Error al conectar con la base de datos."+e.message,e)
        }
    }
    override suspend fun borrarMedico(medico: Medico) {
        return database.medicoDao().borrar(medico.toEntity())
    }
    override suspend fun sincronizarMedicos() {
        try {
            val medicosRemotos = apiService.getMedicos()
            val entidades = medicosRemotos.map { it.toEntity() }
            database.medicoDao().refrescarMedicos(entidades)
        } catch (e: Exception) {
            Log.e("MedicoRepository", "Error al sincronizar Medicos desde la API " + e.message, e)
        }

    }
}

fun MedicoEntity.toDomain() = Medico(
    id=this.id,
    nombre=this.nombre ?: "Sin nombre",
    correo=this.correo?:"Sin correo",
    RUT=this.RUT?:"Sin RUT",
    password=this.password?:"Sin contraseña",
    celular=this.celular?:0,
    hospitalId=this.hospitalId?:0
)

fun Medico.toEntity() = MedicoEntity (
    id = this.id ?: 0,
    nombre = this.nombre,
    correo = this.correo,
    RUT = this.RUT,
    password = this.password,
    celular = this.celular,
    hospitalId = this.hospitalId
)

fun MedicoDto.toEntity(): MedicoEntity {
    return MedicoEntity(
        id = this.id,
        nombre = this.nombre,
        correo = this.correo,
        RUT = this.rut,
        password = this.password,
        celular = this.celular,
        hospitalId = this.hospitalId
    )
}

fun Medico.toCreateDto(): MedicoCreateDto{
    return MedicoCreateDto(
        nombre = this.nombre,
        correo = this.correo,
        rut = this.RUT,
        password = this.password,
        celular = this.celular,
        hospitalId = this.hospitalId
    )
}