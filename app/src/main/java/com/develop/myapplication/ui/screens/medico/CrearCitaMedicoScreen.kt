package com.develop.myapplication.ui.screens.hospital

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.develop.myapplication.ui.viewmodel.CitaFormViewModel
import com.develop.myapplication.ui.viewmodel.PacienteViewModel
import kotlinx.coroutines.launch

@Composable
fun CrearCitaMedicoScreen(
    formViewModelCita: CitaFormViewModel = hiltViewModel(),
    formViewModelPaciente: PacienteViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = formViewModelPaciente.rut,
                onValueChange = { formViewModelPaciente.rut = it},
                label = { Text("Rut Paciente") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { scope.launch { formViewModelPaciente.onRutChange() }}
            ) {
                Text("Buscar Paciente")
            }
            Card(modifier = Modifier.width(270.dp)) {
                Text(formViewModelPaciente.nombre)
                Spacer(modifier = Modifier.height(16.dp))
                Text(formViewModelPaciente.correo)
                Spacer(modifier = Modifier.height(16.dp))
                Text(formViewModelPaciente.celular)
                Spacer(modifier = Modifier.height(16.dp))
            }

        }
    }
}
