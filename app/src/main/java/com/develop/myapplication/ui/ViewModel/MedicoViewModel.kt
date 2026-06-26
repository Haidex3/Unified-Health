package com.develop.myapplication.ui.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.medico.MedicoRepository
import com.develop.myapplication.ui.model.Medico
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
data class DoctorUiState(
    val isLoading: Boolean = false,
    val mensaje: String? = null,
    val error: String? = null
)

@HiltViewModel
class MedicoViewModel @Inject constructor(
    private val medicoRepository: MedicoRepository
) : ViewModel() {

    var uiState by mutableStateOf(DoctorUiState())
        private set

    fun registrarMedico(
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
                val medico = Medico(
                    nombre = nombre,
                    correo = correo,
                    password = password,
                    RUT = rut,
                    celular = celular.toInt(),
                    hospitalId = hospitalId
                )

                medicoRepository.insertarMedicoBackend(medico)

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
