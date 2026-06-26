package com.develop.myapplication.data.remote.service

import com.develop.myapplication.data.remote.dto.HospitalDto
import com.develop.myapplication.data.remote.dto.MedicoCreateDto
import com.develop.myapplication.data.remote.dto.MedicoDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MedicoApiService {
    @GET("medicos")
    suspend fun getMedicos(): List<MedicoDto>

    @GET("medicos/{id}")
    suspend fun getMedicoById(@Path("id") id: Int): MedicoDto

    @POST("medicos")
    suspend fun createMedico(@Body medico: MedicoCreateDto): MedicoDto
}