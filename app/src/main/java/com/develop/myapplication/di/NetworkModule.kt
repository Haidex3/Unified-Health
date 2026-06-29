package com.develop.myapplication.di

import com.develop.myapplication.data.remote.service.CitaApiService
import com.develop.myapplication.data.remote.service.HorarioHoraApiService
import com.develop.myapplication.data.remote.service.HospitalApiService
import com.develop.myapplication.data.remote.service.MedicoApiService
import com.develop.myapplication.data.remote.service.PacienteApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://172.20.10.13:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideHospitalApiService(retrofit: Retrofit): HospitalApiService = retrofit.create(HospitalApiService::class.java)

    @Provides
    @Singleton
    fun provideMedicoApiService(retrofit: Retrofit): MedicoApiService = retrofit.create(MedicoApiService::class.java)

    @Provides
    @Singleton
    fun providePacienteApiService(retrofit: Retrofit): PacienteApiService = retrofit.create(PacienteApiService::class.java)

    @Provides
    @Singleton
    fun provideHorarioHoraApiService(retrofit: Retrofit): HorarioHoraApiService = retrofit.create(HorarioHoraApiService::class.java)

    @Provides
    @Singleton
    fun provideCitaApiService(retrofit: Retrofit): CitaApiService = retrofit.create(CitaApiService::class.java)
}