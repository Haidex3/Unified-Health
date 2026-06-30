package com.develop.myapplication.data.remote.service

import com.develop.myapplication.data.remote.dto.PacienteCreateDto
import com.develop.myapplication.data.remote.dto.PacienteDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PacienteApiService {
    @GET("pacientes")
    suspend fun getPacientes(): List<PacienteDto>

    @GET("pacientes/{id}")
    suspend fun getPacienteById(@Path("id") id: Int): PacienteDto

    @POST("pacientes")
    suspend fun createPaciente(@Body paciente: PacienteCreateDto): PacienteDto
    @DELETE("pacientes/{id}")
    suspend fun deletePaciente(@Path("id") id: Int): Response<Unit>
}