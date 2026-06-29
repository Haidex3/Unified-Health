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
import com.develop.myapplication.data.local.entity.HospitalEntity
import com.develop.myapplication.data.local.entity.PacienteEntity
import com.develop.myapplication.data.local.entity.MedicoEntity
import com.develop.myapplication.data.local.entity.HorarioHoraEntity
import com.develop.myapplication.data.local.entity.CitaEntity

@Database(
    entities = [
        HospitalEntity::class,
        MedicoEntity::class,
        PacienteEntity::class,
        HorarioHoraEntity::class,
        CitaEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun hospitalDao(): HospitalDao
    abstract fun medicoDao(): MedicoDao
    abstract fun pacienteDao(): PacienteDao
    abstract fun horarioHoraDao(): HorarioHoraDao
    abstract fun citaDao(): CitaDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "unified_health_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it }
            }
        }
    }
}
