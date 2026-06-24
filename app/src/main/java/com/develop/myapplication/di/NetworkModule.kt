package com.develop.myapplication.di

import com.develop.myapplication.data.remote.service.HospitalApiService
import com.develop.myapplication.data.remote.service.MedicoApiService
import com.develop.myapplication.data.remote.service.PacienteApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

/*pagina 6 Retrofit*/
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.2:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
        @Provides
        @Singleton
        fun provideHospitalApiService(retrofit: Retrofit): HospitalApiService {
            return retrofit.create(HospitalApiService::class.java)
        }

        @Provides
        @Singleton
        fun provideMedicoApiService(retrofit: Retrofit): MedicoApiService {
            return retrofit.create(MedicoApiService::class.java)
        }

        @Provides
        @Singleton
        fun providePacienteApiService(retrofit: Retrofit): PacienteApiService {
            return retrofit.create(PacienteApiService::class.java)
        }
    }
