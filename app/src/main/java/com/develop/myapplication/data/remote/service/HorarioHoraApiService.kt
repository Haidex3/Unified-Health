package com.develop.myapplication.data.remote.service


import com.develop.myapplication.data.remote.dto.HorarioHoraDto
import com.develop.myapplication.data.remote.dto.HorarioHoraCreateDto
import com.develop.myapplication.data.remote.dto.HospitalDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HorarioHoraApiService {
    @POST("horario_horas")
    suspend fun createHorario(@Body horario: HorarioHoraCreateDto): HorarioHoraDto
    @GET("Horario_horas")
    suspend fun getHorario(): List<HorarioHoraDto>
    @GET("actividades/{id}")
    suspend fun getHorarioById(@Path("id") id: Int): HorarioHoraDto

}

