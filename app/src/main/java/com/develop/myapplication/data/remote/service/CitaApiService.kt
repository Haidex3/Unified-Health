package com.develop.myapplication.data.remote.service

import com.develop.myapplication.data.remote.dto.CitaCreateDto
import com.develop.myapplication.data.remote.dto.CitaDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CitaApiService {

    @GET("citas")
    suspend fun getCitas(): List<CitaDto>
    @GET("actividades/{id}")
    suspend fun getCitaById(@Path("id") id: Int): CitaDto
    @POST("citas")
    suspend fun createCita(@Body cita: CitaCreateDto): CitaDto
}