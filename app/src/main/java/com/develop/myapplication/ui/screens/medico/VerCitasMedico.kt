package com.develop.myapplication.ui.screens.medico

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.develop.myapplication.ui.viewmodel.CitaFormViewModel
/*
@Composable
fun VerCitasMedicoScreen(
    navController: NavHostController,
    viewModel: CitaFormViewModel = hiltViewModel()
) {
    val citas by viewModel.citas.collectAsState()



    Scaffold {
        innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp)) {
            Text("Citas del mÃ©dico ID $medicoId")
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
}*/