package com.develop.myapplication.ui.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.remote.dto.HospitalDto
import com.develop.myapplication.data.remote.service.HospitalApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch


data class HospitalUiState(
    val isLoading: Boolean = false,
    val mensaje: String? = null,
    val error: String? = null
)

@HiltViewModel
class HospitalViewModel @Inject constructor(
    private val hospitalRepository: HospitalApiService
) : ViewModel() {

    var uiState by mutableStateOf(HospitalUiState())
        private set


    fun registrarHospital(
        nombre: String,
        correo: String,
        telefono: String,
        ubicacion: String
    ) {
        viewModelScope.launch {

            uiState = uiState.copy(isLoading = true)

            try {
                val hospital = HospitalDto(
                    nombre = nombre,
                    correo = correo,
                    telefono = telefono,
                    ubicacion = ubicacion,
                )

                    hospitalRepository.createHospital(hospital)

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