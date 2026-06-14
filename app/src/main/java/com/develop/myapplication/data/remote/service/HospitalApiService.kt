package com.develop.myapplication.data.remote.service

import com.develop.myapplication.data.remote.dto.HospitalDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HospitalApiService{
    @GET("hospital")
    suspend fun getHospital(): List<HospitalDto>
    @GET("actividades/{id}")
    suspend fun getHospitalById(@Path("id") id: Int): HospitalDto
    @POST("hospitales")
    suspend fun createHospital(@Body hospital: HospitalDto): HospitalDto
}