package com.develop.myapplication.data.remote.service

import HorarioHoraCreateDto
import com.develop.myapplication.data.remote.dto.HorarioHoraDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HorarioHoraApiService{
    @GET("horarioHoras")
    suspend fun getHorarioHoras(): List<HorarioHoraDto>
    @GET("horarioHoras/{id}")
    suspend fun getHorarioHoraById(@Path("id") id: Int): HorarioHoraDto
    @POST("horarioHoras")
    suspend fun createHorarioHora(@Body horarioHora: HorarioHoraCreateDto): HorarioHoraDto
}
