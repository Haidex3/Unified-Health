package com.develop.myapplication.ui.screens.medico
/*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.paciente.PacienteRepository
import com.develop.myapplication.ui.model.Paciente
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class RegistrarPacienteUiState(
    val isLoading: Boolean = false,
    val mensaje: String? = null,
    val error: String? = null
)

@HiltViewModel
class RegistrarPacienteViewModel @Inject constructor(
    private val pacienteRepository: PacienteRepository
) : ViewModel() {

    var uiState by mutableStateOf(RegistrarPacienteUiState())
        private set

    fun registrarPaciente(
        nombre: String,
        correo: String,
        rut: String,
        sexo: String,
        celular: String,
        password: String,
        hospitalId: Int
    ) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)

            val celularInt = celular.toIntOrNull()
            if (celularInt == null) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = "El celular debe ser un número válido"
                )
                return@launch
            }

            try {
                val paciente = Paciente(
                    id = 0,
                    nombre = nombre,
                    correo = correo,
                    RUT = rut,
                    sexo = sexo,
                    celular = celularInt,
                    password = password,
                    hospitalId = hospitalId
                )

                pacienteRepository.insertarPacienteBackend(paciente)

                uiState = uiState.copy(
                    isLoading = false,
                    mensaje = "Paciente registrado correctamente"
                )
            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = "Error al registrar paciente: ${e.message}"
                )
            }
        }
    }

    fun limpiarMensaje() {
        uiState = uiState.copy(mensaje = null, error = null)
    }
}

@Composable
fun RegistrarPacienteScreen(
    viewModel: RegistrarPacienteViewModel = hiltViewModel()
) {
    var nombre by remember { mutableStateOf("") }
    var rut by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var hospitalId by remember { mutableStateOf("") }

    val uiState = viewModel.uiState

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Registrar Paciente")
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = rut, onValueChange = { rut = it }, label = { Text("RUT") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = correo, onValueChange = { correo = it }, label = { Text("Correo") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = sexo, onValueChange = { sexo = it }, label = { Text("Sexo") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = celular, onValueChange = { celular = it }, label = { Text("Celular") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Contraseña") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = hospitalId, onValueChange = { hospitalId = it }, label = { Text("ID Hospital") })

            Spacer(modifier = Modifier.height(16.dp))

            if (uiState.isLoading) {
                CircularProgressIndicator()
            } else {
                Button(
                    onClick = {
                        viewModel.registrarPaciente(
                            nombre = nombre,
                            correo = correo,
                            rut = rut,
                            sexo = sexo,
                            celular = celular,
                            password = password,
                            hospitalId = hospitalId.toIntOrNull() ?: 0
                        )
                    }
                ) {
                    Text("Guardar Paciente")
                }
            }

            uiState.mensaje?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(it)
            }
            uiState.error?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(it)
            }
        }
    }
}
*/