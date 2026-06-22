package com.develop.myapplication.data.repository

import android.content.Context
import com.develop.myapplication.data.local.AppDatabase
import com.develop.myapplication.data.repository.hospital.HospitalRepository
import com.develop.myapplication.data.repository.hospital.HospitalRepositoryImpl
import com.develop.myapplication.di.NetworkModule

interface AppContainer {
    val hospitalRepository : HospitalRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val hospitalRepository: HospitalRepository by lazy {
        HospitalRepositoryImpl(AppDatabase.getDatabase(context),
            NetworkModule.provideHospitalApiService(NetworkModule.provideRetrofit()))
    }
}
