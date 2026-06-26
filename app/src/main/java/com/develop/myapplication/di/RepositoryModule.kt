package com.develop.myapplication.di

import com.develop.myapplication.data.repository.hospital.HospitalRepository
import com.develop.myapplication.data.repository.hospital.HospitalRepositoryImpl
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
}
    /*
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
    */



