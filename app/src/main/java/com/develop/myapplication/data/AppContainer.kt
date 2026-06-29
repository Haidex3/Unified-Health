package com.develop.myapplication.data

import android.content.Context
import com.develop.myapplication.data.local.AppDatabase
import com.develop.myapplication.data.repository.horarioHora.HorarioHoraRepository
import com.develop.myapplication.data.repository.horarioHora.HorarioHoraRepositoryImpl
import com.develop.myapplication.data.repository.hospital.HospitalRepository
import com.develop.myapplication.data.repository.hospital.HospitalRepositoryImpl
import com.develop.myapplication.data.repository.medico.MedicoRepository
import com.develop.myapplication.data.repository.medico.MedicoRepositoryImpl
import com.develop.myapplication.data.repository.paciente.PacienteRepository
import com.develop.myapplication.data.repository.paciente.PacienteRepositoryImpl

import com.develop.myapplication.di.NetworkModule


interface AppContainer {
    val hospitalRepository : HospitalRepository
    val horarioHorasRepository : HorarioHoraRepository
    val medicoRepository : MedicoRepository
    val pacienteRepository : PacienteRepository
}
class AppDataContainer(private val context: Context) : AppContainer {
    override val hospitalRepository: HospitalRepository by lazy {
        HospitalRepositoryImpl(
            AppDatabase.getDatabase(context),
            NetworkModule.provideHospitalApiService(NetworkModule.provideRetrofit()))
    }
    override val horarioHorasRepository: HorarioHoraRepository by lazy{
        HorarioHoraRepositoryImpl(
            AppDatabase.getDatabase(context),
            NetworkModule.provideHorarioHoraApiService(retrofit=NetworkModule.provideRetrofit()))
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


}