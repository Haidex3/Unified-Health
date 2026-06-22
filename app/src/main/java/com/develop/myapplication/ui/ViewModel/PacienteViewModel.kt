package com.develop.myapplication.ui.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.remote.dto.PacienteDto
import com.develop.myapplication.data.remote.service.PacienteApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

// 🔹 Estado simple
data class PacienteUiState(
    val isLoading: Boolean = false,
    val mensaje: String? = null,
    val error: String? = null
)

@HiltViewModel
class PacienteViewModel @Inject constructor(
    private val pacienteRepository: PacienteApiService
) : ViewModel() {

    var uiState by mutableStateOf(PacienteUiState())
        private set

    fun registrarPaciente(
        nombre: String,
        apellido: String,
        rut: String,
        correo: String,
        sexo: String,
        celular: String,
        hospitalId: Int
    ) {
        viewModelScope.launch {

            uiState = uiState.copy(isLoading = true)

            try {
                val paciente = PacienteDto(
                    nombre = nombre,
                    correo = correo,
                    rut = rut,
                    sexo = sexo,
                    celular = celular,
                    hospitalId = hospitalId
                )


                pacienteRepository.createPaciente(paciente)

                uiState = uiState.copy(
                    isLoading = false,
                    mensaje = "Paciente registrado correctamente"
                )

            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = "Error al registrar paciente"
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