package com.develop.myapplication.di

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
    abstract fun bindHospitalRepository(
        hospitalRepositoryImpl: HospitalRepositoryImpl
    ): HospitalRepository

    @Binds
    @Singleton
    abstract fun bindMedicoRepository(
        medicoRepositoryImpl: MedicoRepositoryImpl
    ): MedicoRepository

    @Binds
    @Singleton
    abstract fun bindPacienteRepository(
        pacienteRepositoryImpl: PacienteRepositoryImpl
    ): PacienteRepository

    @Binds
    @Singleton
    abstract fun bindHorario_horasRepository(
        horario_horasRepositoryImpl: Horario_horasRepositoryImpl
    ): Horario_horasRepository

    @Binds
    @Singleton
    abstract fun bindCitasRepository(
        citaRepositoryImpl: CitaRepositoryImpl
    ): CitaRepository

}


