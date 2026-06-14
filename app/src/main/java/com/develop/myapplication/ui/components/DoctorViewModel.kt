package com.develop.myapplication.ui.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.model.Doctor
import com.develop.myapplication.network.NetworkModule
import kotlinx.coroutines.launch

data class DoctorUiState(
    val isLoading: Boolean = false,
    val mensaje: String? = null,
    val error: String? = null
)

class DoctorViewModel : ViewModel() {

    var uiState by mutableStateOf(DoctorUiState())
        private set

    fun registrarDoctor(
        nombre: String,
        correo: String,
        password: String,
        rut: String,
        celular: String,
        hospitalId: Int
    ) {
        viewModelScope.launch {

            uiState = uiState.copy(isLoading = true)

            try {
                val doctor = Doctor(
                    nombre = nombre,
                    correo = correo,
                    password = password,
                    rut = rut,
                    celular = celular,
                    hospital_id = hospitalId
                )


                NetworkModule.api.createDoctor(doctor)

                uiState = uiState.copy(
                    isLoading = false,
                    mensaje = "Doctor creado correctamente"
                )

            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = "Error al crear doctor"
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