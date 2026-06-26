package com.develop.myapplication.data.repository.paciente


import android.util.Log
import com.develop.myapplication.data.local.AppDatabase
import com.develop.myapplication.data.local.entity.PacienteEntity
import com.develop.myapplication.data.remote.dto.PacienteCreateDto
import com.develop.myapplication.data.remote.dto.PacienteDto
import com.develop.myapplication.data.remote.service.PacienteApiService
import com.develop.myapplication.ui.model.Paciente
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PacienteRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiService: PacienteApiService
): PacienteRepository{
    override fun obtenerTodosPacientes(): Flow<List<Paciente>> {
        return database.pacienteDao().obtenerTodos().map { it.map { it.toDomain() } }
    }
    override suspend fun insertarPaciente(paciente: Paciente) {
        database.pacienteDao().insertarTodos(paciente.toEntity())
    }
    override suspend fun obtenerPorId(id: Int): Paciente? {
        return database.pacienteDao().obtenerPorId(id)?.toDomain()
    }
    override suspend fun buscarPorNombre(nombreBusqeda: String): Paciente? {
        return database.pacienteDao().buscarPorNombre(nombreBusqeda)?.toDomain()
    }
    override suspend fun insertarPacienteBackend(paciente: Paciente) {
        try {
            val pacienteApi = apiService.createPaciente(paciente.toCreateDto())
            database.pacienteDao().insertarTodos(pacienteApi.toEntity())
        }catch (e: Exception){
            Log.e("Fallo","Error al conectar con la base de datos."+e.message,e)
        }
    }
    override suspend fun borrarPaciente(paciente: Paciente) {
        return database.pacienteDao().borrar(paciente.toEntity())
    }
    override suspend fun sincronizarPacientes() {
        try {
            val pacientesRemotos = apiService.getPacientes()
            val entidades = pacientesRemotos.map { it.toEntity() }
            database.pacienteDao().refrescarPacientes(entidades)
        } catch (e: Exception) {
            Log.e("PacienteRepository", "Error al sincronizar Pacientes desde la API " + e.message, e)
        }

    }
}

fun PacienteEntity.toDomain() = Paciente(
    id=this.id,
    nombre=this.nombre ?: "Sin nombre",
    correo=this.correo?:"Sin correo",
    RUT=this.RUT?:"Sin RUT",
    sexo=this.sexo?:"Sin sexo",
    celular=this.celular?:0,
    password=this.password?:"Sin contraseña",
    hospitalId=this.hospitalId?:0
)

fun Paciente.toEntity() = PacienteEntity (
    id = this.id,
    nombre = this.nombre,
    correo = this.correo,
    RUT = this.RUT,
    sexo = this.sexo,
    celular = this.celular,
    password = this.password,
    hospitalId = this.hospitalId
)

fun PacienteDto.toEntity(): PacienteEntity {
    return PacienteEntity(
        id = this.id,
        nombre = this.nombre,
        correo = this.correo,
        RUT = this.RUT,
        sexo = this.sexo,
        celular = this.celular,
        password = this.password,
        hospitalId = this.hospitalId
    )
}

fun Paciente.toCreateDto(): PacienteCreateDto{
    return PacienteCreateDto(
        nombre = this.nombre,
        correo = this.correo,
        RUT = this.RUT,
        sexo = this.sexo,
        celular = this.celular,
        password = this.password,
        hospitalId = this.hospitalId
    )
}
