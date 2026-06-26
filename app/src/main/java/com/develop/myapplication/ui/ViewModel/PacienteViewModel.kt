package com.develop.myapplication.ui.ViewModel
/*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PacienteViewModel @Inject constructor(
    private val pacienteRepository: PacienteRepository
)
{

}



// 🔹 Estado simple
data class PacienteUiState(
    val isLoading: Boolean = false,
    val mensaje: String? = null,
    val error: String? = null
)

class PacienteViewModel : ViewModel() {

    var uiState by mutableStateOf(PacienteUiState())
        private set

    fun registrarPaciente(
        nombre: String,
        apellido: String,
        rut: String,
        correo: String,
        sexo: String,
        celular: String
    ) {
        viewModelScope.launch {

            uiState = uiState.copy(isLoading = true)

            try {
                val paciente = Paciente(
                    nombre = nombre,
                    apellido = apellido,
                    rut = rut,
                    correo = correo,
                    sexo = sexo,
                    num_celular = celular
                )

                // 🔥 llamada API
                DataBaseModule.createPaciente(paciente)

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
}*/