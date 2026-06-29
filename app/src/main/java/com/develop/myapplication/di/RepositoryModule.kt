package com.develop.myapplication.di

import com.develop.myapplication.data.repository.cita.CitaRepository
import com.develop.myapplication.data.repository.cita.CitaRepositoryImpl
import com.develop.myapplication.data.repository.horarioHora.HorarioHoraRepository
import com.develop.myapplication.data.repository.horarioHora.HorarioHoraRepositoryImpl
import com.develop.myapplication.data.repository.hospital.HospitalRepository
import com.develop.myapplication.data.repository.hospital.HospitalRepositoryImpl
import com.develop.myapplication.data.repository.medico.MedicoRepository
import com.develop.myapplication.data.repository.medico.MedicoRepositoryImpl
import com.develop.myapplication.data.repository.paciente.PacienteRepository
import com.develop.myapplication.data.repository.paciente.PacienteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindHospitalRepository(impl: HospitalRepositoryImpl): HospitalRepository

    @Binds
    @Singleton
    abstract fun bindMedicoRepository(impl: MedicoRepositoryImpl): MedicoRepository

    @Binds
    @Singleton
    abstract fun bindPacienteRepository(impl: PacienteRepositoryImpl): PacienteRepository

    @Binds
    @Singleton
    abstract fun bindHorarioHoraRepository(impl: HorarioHoraRepositoryImpl): HorarioHoraRepository

    @Binds
    @Singleton
    abstract fun bindCitaRepository(impl: CitaRepositoryImpl): CitaRepository
}



