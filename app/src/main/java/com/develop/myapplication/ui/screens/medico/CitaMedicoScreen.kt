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
import com.develop.myapplication.ui.viewmodel.CitaFormViewModel
import com.develop.myapplication.ui.viewmodel.HorarioHoraFormViewModel
import com.develop.myapplication.ui.viewmodel.PacienteViewModel

@Composable
fun CitasMedicoScreen(
    navController: NavHostController? = null,
    medicoId: Int,
    citaViewModel: CitaFormViewModel = hiltViewModel(),
    horarioHoraViewModel: HorarioHoraFormViewModel = hiltViewModel(),
    pacienteViewModel: PacienteViewModel = hiltViewModel()
) {
    val citas by citaViewModel.citas.collectAsState()
    val horarios by horarioHoraViewModel.horarios.collectAsState()
    val pacientes by pacienteViewModel.pacientes.collectAsState()


    val horariosDelMedico = horarios.filter { it.idMedico == medicoId }
    val idsHorariosDelMedico = horariosDelMedico.map { it.id }.toSet()


    val citasDelMedico = citas.filter { it.idHorarioHora in idsHorariosDelMedico }

    fun actualizar() {
        citaViewModel.actualizarDatos()
        horarioHoraViewModel.actualizarDatos()
        pacienteViewModel.actualizarDatos()
    }

    LaunchedEffect(medicoId) {
        actualizar()
    }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text("Citas del médico ID $medicoId")
            Button(
                onClick = { actualizar() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Actualizar lista de citas")
            }
            if (citasDelMedico.isEmpty()) {
                Text("Este médico no tiene citas registradas.")
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(citasDelMedico) { cita ->
                        val paciente = pacientes.find { it.id == cita.idPaciente }

                        Card(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text("Cita ID: ${cita.id}")
                                Text("Fecha: ${cita.fecha}")
                                Text("Paciente: ${paciente?.nombre ?: cita.idPaciente.toString()}")
                                Text("Detalles: ${cita.detalle}")
                                Text("Conclusiones: ${cita.conclusion}")
                            }
                        }
                    }
                }
            }
        }
    }
}