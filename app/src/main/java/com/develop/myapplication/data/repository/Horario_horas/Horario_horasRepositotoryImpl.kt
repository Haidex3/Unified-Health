package com.develop.myapplication.data.repository.Horario_horas

import android.util.Log
import com.develop.myapplication.data.local.AppDatabase
import com.develop.myapplication.data.local.entity.Horario_horasEntity
import com.develop.myapplication.ui.model.Horario_horas
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//import com.develop.myapplication.data.remote.dto.HospitalDto
//import com.develop.myapplication.data.remote.service.HospitalApiService

/*
class UsuarioRepositoryImpl @Inject constructor(
    private val database: AppDatabase
    ) : UsuarioRepository {

    override fun obtenerTodosUsuarios(): Flow<List<Usuario>> {
        return database.usuarioDao().obtenerTodos().map { listaEntities ->
            listaEntities.map { entity -> entity.toDomain()
            }
        }
    }

    override suspend fun obtenerPorId(id: Int): Usuario {
        return database.usuarioDao().obtenerPorId(id).toDomain()
    }

    override suspend fun insertarUsuario(usuario: Usuario) {
        return database.usuarioDao().insertarTodos(usuario.toEntity())
    }

    override suspend fun borrarUsuario(usuario: Usuario) {
        return database.usuarioDao().borrar(usuario.toEntity())
    }

}

fun UsuarioEntity.toDomain() = Usuario(
    id = this.id,
    nombre = this.nombre ?: "Sin nombre",
    edad = this.edad ?: 0,
    vigente = this.vigente ?: false
)

fun Usuario.toEntity() = UsuarioEntity(
    id = this.id,
    nombre = this.nombre,
    edad = this.edad,
    vigente = this.vigente
)
*/

/*
    fun obtenerTodos(): Flow<List<Horario_horasEntity>>?
    suspend fun obtenerPorId(id: Int): Horario_horasEntity?
    suspend fun obtenerPorId(userIds: IntArray): List<Horario_horasEntity>?
    suspend fun insertarTodos(vararg horario: Horario_horasEntity)
    suspend fun borrar(horario: Horario_horasEntity)
*/

class Horario_horasImpl  @Inject constructor(
    private val database: AppDatabase
) : Horario_horasRepository {
    override fun obtenerTodos(): Flow<List<Horario_horasEntity>>? {
        return database.Horario_horasDao().obtenerTodos().map{ listaEntities ->
            listaEntities.map { entity -> entity.toDomain()
            }
        }
    }
}

