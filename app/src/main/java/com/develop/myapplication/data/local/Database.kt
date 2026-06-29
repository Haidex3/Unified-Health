package com.develop.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.develop.myapplication.data.local.dao.CitaDao
import com.develop.myapplication.data.local.dao.HorarioHoraDao
import com.develop.myapplication.data.local.dao.HospitalDao
import com.develop.myapplication.data.local.dao.MedicoDao
import com.develop.myapplication.data.local.dao.PacienteDao
import com.develop.myapplication.data.local.entity.CitaEntity
import com.develop.myapplication.data.local.entity.HorarioHoraEntity
import com.develop.myapplication.data.local.entity.HospitalEntity
import com.develop.myapplication.data.local.entity.MedicoEntity
import com.develop.myapplication.data.local.entity.PacienteEntity

@Database(entities = [HospitalEntity::class, HorarioHoraEntity::class, PacienteEntity::class, MedicoEntity::class, CitaEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun hospitalDao(): HospitalDao
    abstract fun medicoDao(): MedicoDao
    abstract fun horarioHoraDao(): HorarioHoraDao
    abstract fun pacienteDao(): PacienteDao
    abstract fun citaDao(): CitaDao
    companion object {
        @Volatile
        private var Instance: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "App_database")
                    .build().also { Instance = it }
            }
        }

    }
}