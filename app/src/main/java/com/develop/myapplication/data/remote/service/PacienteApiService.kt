package com.develop.myapplication.data.remote.service

import com.develop.myapplication.data.remote.dto.PacienteDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PacienteApiService {
    @GET("pacientes")
    suspend fun getPacientes(): List<PacienteDto>

    @POST("pacientes")
    suspend fun createPaciente(@Body paciente: PacienteDto): PacienteDto

}