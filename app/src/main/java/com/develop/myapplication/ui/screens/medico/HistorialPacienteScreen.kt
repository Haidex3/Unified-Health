package com.develop.myapplication.ui.screens.medico

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.develop.myapplication.ui.model.components.CitaViewModel
import com.develop.myapplication.ui.components.PacienteViewModel

@Composable
fun HistorialPacienteScreen(
    navController: NavHostController? = null,
    pacienteIdInicial: Int = 0,
    citaViewModel: CitaViewModel = hiltViewModel(),
    pacienteViewModel: PacienteViewModel = hiltViewModel()
) {
    val citas by citaViewModel.citas.collectAsState()
    val pacientes by pacienteViewModel.pacientes.collectAsState()

    var pacienteIdTexto by remember {
        mutableStateOf(
            if (pacienteIdInicial > 0) pacienteIdInicial.toString() else ""
        )
    }

    val pacienteId = pacienteIdTexto.toIntOrNull()

    val pacienteEncontrado = pacientes.find { paciente ->
        paciente.id == pacienteId
    }

    val historialPaciente = if (pacienteId != null) {
        citas.filter { cita ->
            cita.pacienteId == pacienteId
        }
    } else {
        emptyList()
    }

    LaunchedEffect(Unit) {
        pacienteViewModel.actualizarDatos()
    }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Historial del paciente",
                style = MaterialTheme.typography.headlineSmall
            )

            OutlinedTextField(
                value = pacienteIdTexto,
                onValueChange = { pacienteIdTexto = it },
                label = { Text("ID del paciente") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            Button(
                onClick = {
                    pacienteViewModel.actualizarDatos()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Buscar historial")
            }

            if (pacienteIdTexto.isBlank()) {
                Text("Ingresa el ID del paciente para ver su historial.")
            } else if (pacienteId == null) {
                Text("El ID del paciente debe ser un número.")
            } else {
                if (pacienteEncontrado != null) {
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text("Paciente: ${pacienteEncontrado.nombre}")
                            Text("RUT: ${pacienteEncontrado.RUT}")
                            Text("Correo: ${pacienteEncontrado.correo}")
                            Text("Celular: ${pacienteEncontrado.celular}")
                            Text("Sexo: ${pacienteEncontrado.sexo}")
                        }
                    }
                } else {
                    Text("No se encontró información del paciente.")
                }

                Text(
                    text = "Citas registradas",
                    style = MaterialTheme.typography.titleMedium
                )

                if (historialPaciente.isEmpty()) {
                    Text("Este paciente no tiene citas registradas.")
                } else {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(historialPaciente) { cita ->
                            Card(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Text("Cita ID: ${cita.id}")
                                    Text("Fecha: ${cita.fecha}")
                                    Text("Hora: ${cita.hora ?: "Sin hora registrada"}")
                                    Text("Médico ID: ${cita.medicoId ?: "Sin médico"}")
                                    Text("Detalles: ${cita.detalles}")
                                    Text("Conclusiones: ${cita.conclusiones}")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}