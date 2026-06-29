package com.develop.myapplication.ui.screens.medico

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.develop.myapplication.ui.components.CitaViewModel

@Composable
fun CitasMedicoScreen(
    navController: NavHostController? = null,
    medicoId: Int,
    viewModel: CitaViewModel = hiltViewModel()
) {
    val citas by viewModel.citas.collectAsState()

    LaunchedEffect(medicoId) {
        viewModel.cargarCitasMedico(medicoId)
    }

    Scaffold { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp)) {
            Text("Citas del médico ID $medicoId")
            Button(onClick = { viewModel.cargarCitasMedico(medicoId) }, modifier = Modifier.fillMaxWidth()) {
                Text("Actualizar lista de citas")
            }
            LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(citas) { cita ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Cita ID: ${cita.id}")
                            Text("Fecha: ${cita.fecha}")
                            Text("Hora: ${cita.hora ?: "Sin hora"}")
                            Text("Paciente: ${cita.pacienteNombre ?: cita.pacienteId.toString()}")
                            Text("Detalles: ${cita.detalles}")
                            Text("Conclusiones: ${cita.conclusiones}")
                        }
                    }
                }
            }
        }
    }
}