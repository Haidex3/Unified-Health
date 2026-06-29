package com.develop.myapplication.data

import android.content.Context
import com.develop.myapplication.data.local.AppDatabase
import com.develop.myapplication.data.repository.Cita.CitaRepository
import com.develop.myapplication.data.repository.Cita.CitaRepositoryImpl
import com.develop.myapplication.data.repository.Horario_horas.Horario_horasRepository
import com.develop.myapplication.data.repository.Horario_horas.Horario_horasRepositoryImpl
import com.develop.myapplication.data.repository.hospital.HospitalRepository
import com.develop.myapplication.data.repository.hospital.HospitalRepositoryImpl
import com.develop.myapplication.data.repository.medico.MedicoRepository
import com.develop.myapplication.data.repository.medico.MedicoRepositoryImpl
import com.develop.myapplication.data.repository.paciente.PacienteRepository
import com.develop.myapplication.data.repository.paciente.PacienteRepositoryImpl

import com.develop.myapplication.di.NetworkModule

interface AppContainer {
    val hospitalRepository : HospitalRepository
    val horario_HorasRepository : Horario_horasRepository
    val medicoRepository : MedicoRepository
    val pacienteRepository : PacienteRepository

    val citaRepository : CitaRepository

}
class AppDataContainer(private val context: Context) : AppContainer {
    override val hospitalRepository: HospitalRepository by lazy {
        HospitalRepositoryImpl(
            AppDatabase.getDatabase(context),
        NetworkModule.provideHospitalApiService(NetworkModule.provideRetrofit()))
    }
    override val horario_HorasRepository: Horario_horasRepository by lazy{
        Horario_horasRepositoryImpl(
            AppDatabase.getDatabase(context),
            NetworkModule.provideHorario_citasApiService(retrofit=NetworkModule.provideRetrofit()))
    }
    override val medicoRepository: MedicoRepository by lazy{
        MedicoRepositoryImpl(
            AppDatabase.getDatabase(context),
            NetworkModule.provideMedicoApiService(retrofit=NetworkModule.provideRetrofit()))
    }

    override val pacienteRepository: PacienteRepository by lazy{
        PacienteRepositoryImpl(
            AppDatabase.getDatabase(context),
            NetworkModule.providePacienteApiService(retrofit=NetworkModule.provideRetrofit()))
    }

    override val citaRepository: CitaRepository by lazy{
        CitaRepositoryImpl(
            AppDatabase.getDatabase(context),
            NetworkModule.provideCitaApiService(retrofit = NetworkModule.provideRetrofit())
        )
    }

}