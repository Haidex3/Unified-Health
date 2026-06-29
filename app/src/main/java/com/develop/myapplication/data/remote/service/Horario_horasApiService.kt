package com.develop.myapplication.data.remote.service


import com.develop.myapplication.data.remote.dto.Horario_horasDto
import com.develop.myapplication.data.remote.dto.Horario_horasCreate
import com.develop.myapplication.data.remote.dto.HospitalDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Horario_horasApiService {
@POST("horario_horas")
suspend fun createHorario(@Body horario: Horario_horasCreate): Horario_horasDto
@GET("Horario_horas")
suspend fun getHorario(): List<Horario_horasDto>
@GET("actividades/{id}")
suspend fun getHorarioById(@Path("id") id: Int): Horario_horasDto

}

