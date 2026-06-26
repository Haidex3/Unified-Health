package com.develop.myapplication.ui.screens.paciente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.myapplication.data.repository.paciente.PacienteRepository
import com.develop.myapplication.ui.model.Paciente
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class InformacionPacienteUiState(
    val isLoading: Boolean = false,
    val paciente: Paciente? = null,
    val error: String? = null
)

@HiltViewModel
class InformacionPacienteViewModel @Inject constructor(
    private val pacienteRepository: PacienteRepository
) : ViewModel() {

    var uiState by mutableStateOf(InformacionPacienteUiState())
        private set

    fun cargarPaciente(id: Int) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)
            try {
                val paciente = pacienteRepository.obtenerPorId(id)
                if (paciente != null) {
                    uiState = uiState.copy(isLoading = false, paciente = paciente)
                } else {
                    uiState = uiState.copy(
                        isLoading = false,
                        error = "No se encontró ningún paciente con ese ID"
                    )
                }
            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = "Error al cargar el paciente: ${e.message}"
                )
            }
        }
    }
}

@Composable
fun InformacionPacienteScreen(
    pacienteId: Int,
    viewModel: InformacionPacienteViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState

    LaunchedEffect(pacienteId) {
        viewModel.cargarPaciente(pacienteId)
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Información del Paciente")
            Spacer(modifier = Modifier.height(16.dp))

            when {
                uiState.isLoading -> {
                    CircularProgressIndicator()
                }
                uiState.paciente != null -> {
                    val paciente = uiState.paciente
                    Card(modifier = Modifier.fillMaxSize().padding(8.dp)) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text("Nombre: ${paciente.nombre}")
                            Text("RUT: ${paciente.RUT}")
                            Text("Correo: ${paciente.correo}")
                            Text("Sexo: ${paciente.sexo}")
                            Text("Celular: ${paciente.celular}")
                            Text("ID Hospital: ${paciente.hospitalId}")
                        }
                    }
                }
                uiState.error != null -> {
                    Text(uiState.error)
                }
            }
        }
    }
}
