package com.develop.myapplication.ui.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.remote.dto.MedicoDto
import com.develop.myapplication.data.remote.service.MedicoApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch
data class MedicoUiState(
    val isLoading: Boolean = false,
    val mensaje: String? = null,
    val error: String? = null
)

@HiltViewModel
class MedicoViewModel @Inject constructor(
    private val medicoRepository: MedicoApiService
): ViewModel() {
    var uiState by mutableStateOf(MedicoUiState())
        private set
    fun registrarMedico(
        nombre: String,
        correo: String,
        rut: String,
        password: String,
        celular: Int,
        hospitalId: Int
    ) {
        viewModelScope.launch {

            uiState = uiState.copy(isLoading = true)

            try {
                val medico = MedicoDto(
                    nombre = nombre,
                    correo = correo,
                    rut = rut,
                    contrasena = password,
                    celular = celular,
                    hospitalId = hospitalId
                )
                medicoRepository.createMedico(medico)

                uiState = uiState.copy(
                    isLoading = false,
                    mensaje = "Medico creado correctamente"
                )

            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = "Error al crear medico"
                )
            }
        }
    }

    fun limpiarMensaje() {
        uiState = uiState.copy(mensaje = null, error = null)
    }
}