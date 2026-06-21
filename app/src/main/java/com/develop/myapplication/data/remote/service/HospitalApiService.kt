package com.develop.myapplication.data.remote.service

import com.develop.myapplication.data.remote.dto.HospitalDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface HospitalApiService {
    @GET("hospitales")
    suspend fun getHospitales(): List<HospitalDto>

    @POST("hospitales")
    suspend fun createHospital(@Body hospital: HospitalDto): HospitalDto

}