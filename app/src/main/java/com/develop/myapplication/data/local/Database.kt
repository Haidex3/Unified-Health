package com.develop.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.develop.myapplication.data.local.dao.HospitalDao
import com.develop.myapplication.data.local.dao.MedicoDao
import com.develop.myapplication.data.local.dao.PacienteDao
import com.develop.myapplication.data.local.entity.HospitalEntity
import com.develop.myapplication.data.local.dao.Horario_horasDao
import com.develop.myapplication.data.local.entity.Horario_horasEntity
import com.develop.myapplication.data.local.dao.UsuarioDao
import com.develop.myapplication.data.local.entity.UsuarioEntity
import com.develop.myapplication.data.local.entity.MedicoEntity
import com.develop.myapplication.data.local.entity.PacienteEntity


@Database(entities = [HospitalEntity::class,Horario_horasEntity::class,UsuarioEntity::class, PacienteEntity::class, MedicoEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun hospitalDao(): HospitalDao
    abstract fun usuarioDao(): UsuarioDao
    abstract fun medicoDao(): MedicoDao
    abstract fun Horario_horasDao(): Horario_horasDao

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