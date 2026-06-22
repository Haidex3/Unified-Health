package com.develop.myapplication.ui.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.model.Hospital
import com.develop.myapplication.network.NetworkModule
import kotlinx.coroutines.launch

// 🔹 Estado simple
data class HospitalUiState(
    val isLoading: Boolean = false,
    val mensaje: String? = null,
    val error: String? = null
)

class HospitalViewModel : ViewModel() {

    var uiState by mutableStateOf(HospitalUiState())
        private set

    fun registrarHospital(
        nombre: String,
        correo: String,
        ubicacion: String
    ) {
        viewModelScope.launch {

            uiState = uiState.copy(isLoading = true)

            try {
                val hospital = Hospital(
                    nombre = nombre,
                    correo = correo,
                    ubicacion = ubicacion
                )

                // 🔥 llamada API
                NetworkModule.api.createHospital(hospital)

                uiState = uiState.copy(
                    isLoading = false,
                    mensaje = "Hospital creado correctamente"
                )

            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = "Error al crear hospital"
                )
            }
        }
    }

    fun limpiarMensaje() {
        uiState = uiState.copy(
            mensaje = null,
            error = null
        )
    }
}