package com.develop.myapplication.data.remote.service

import com.develop.myapplication.data.remote.dto.HospitalDto
import com.develop.myapplication.data.remote.dto.PacienteDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PacienteApiService {
    @GET("pacientes")
    suspend fun getPacientes(): List<PacienteDto>

    @GET("actividades/{id}")
    suspend fun getPacienteById(@Path("id") id: Int): PacienteDto

    @POST("pacientes")
    suspend fun createPaciente(@Body paciente: PacienteDto): PacienteDto

}