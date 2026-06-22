package com.develop.myapplication.data.remote.service

import com.develop.myapplication.data.remote.dto.MedicoDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MedicoApiService {
    @GET("medicos")
    suspend fun getMedicos(): List<MedicoDto>

    @POST("medicos")
    suspend fun createMedico(@Body medico: MedicoDto): MedicoDto
}
