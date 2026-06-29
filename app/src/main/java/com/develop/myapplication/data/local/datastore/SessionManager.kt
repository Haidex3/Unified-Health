package com.develop.myapplication.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.develop.myapplication.data.remote.dto.LoginResponseDto
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore("session")

@Singleton
class SessionManager @Inject constructor(
    @ApplicationContext private val context: Context
) {

    companion object {

        val TOKEN = stringPreferencesKey("token")
        val USER_ID = intPreferencesKey("user_id")
        val USER_NAME = stringPreferencesKey("user_name")
        val USER_EMAIL = stringPreferencesKey("user_email")
        val USER_RUT = stringPreferencesKey("user_rut")
        val USER_TYPE = stringPreferencesKey("user_type")
    }

    suspend fun saveLogin(response: LoginResponseDto) {

        context.dataStore.edit {

            it[TOKEN] = response.token
            it[USER_ID] = response.user.id
            it[USER_NAME] = response.user.nombre
            it[USER_EMAIL] = response.user.correo
            it[USER_RUT] = response.user.RUT
            it[USER_TYPE] = response.type
        }
    }

    suspend fun logout() {
        context.dataStore.edit {
            it.clear()
        }
    }

    val token: Flow<String?> =
        context.dataStore.data.map { it[TOKEN] }

    val userType: Flow<String?> =
        context.dataStore.data.map { it[USER_TYPE] }

    val userName: Flow<String?> =
        context.dataStore.data.map { it[USER_NAME] }

    val userId: Flow<Int?> =
        context.dataStore.data.map { it[USER_ID] }
}