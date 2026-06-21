package com.develop.myapplication.di

import com.develop.myapplication.data.remote.service.HospitalApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.173.35.24:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun provideHospitalApiService(retrofit: Retrofit): HospitalApiService {
        return retrofit.create(HospitalApiService::class.java)
    }
}