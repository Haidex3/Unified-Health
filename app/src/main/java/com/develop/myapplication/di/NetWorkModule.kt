package com.develop.myapplication.di

import com.develop.myapplication.data.remote.service.CitaApiService
import com.develop.myapplication.data.remote.service.Horario_horasApiService
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
                .baseUrl("http://192.168.0.2:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        @Provides
        fun provideHospitalApiService(retrofit: Retrofit): HospitalApiService{
            return retrofit.create(HospitalApiService::class.java)
        }

        @Provides
        fun provideHorario_citasApiService(retrofit: Retrofit): Horario_horasApiService{
            return retrofit.create(Horario_horasApiService::class.java)
        }


        @Provides
        fun provideMedicoApiService(retrofit: Retrofit): MedicoApiService {
            return retrofit.create(MedicoApiService::class.java)
        }

        @Provides
        fun providePacienteApiService(retrofit: Retrofit): PacienteApiService {
            return retrofit.create(PacienteApiService::class.java)
        }

    @Provides
    fun provideCitaApiService(retrofit: Retrofit): CitaApiService {
        return retrofit.create(CitaApiService::class.java)
    }
}


