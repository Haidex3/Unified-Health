package com.develop.myapplication.data.remote.service


import com.develop.myapplication.data.remote.dto.HospitalCreateDto
import com.develop.myapplication.data.remote.dto.HospitalDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HospitalApiService{
    @GET("hospitales")
    suspend fun getHospital(): List<HospitalDto>
    @GET("hospital/{id}")
    suspend fun getHospitalById(@Path("id") id: Int): HospitalDto
    @POST("hospitales")
    suspend fun createHospital(@Body hospital: HospitalCreateDto): HospitalDto
    @DELETE("hospitales/{id}")
    suspend fun deleteHospital(@Path("id") id: Int): Response<Unit>

}