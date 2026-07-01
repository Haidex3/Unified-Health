package com.develop.myapplication.ui.screens.medico


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.develop.myapplication.ui.viewmodel.PacienteViewModel
import kotlinx.coroutines.launch

@Composable
fun BuscarPacienteScreen(
    formViewModel: PacienteViewModel = hiltViewModel()
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
                value = formViewModel.rut,
                onValueChange = { formViewModel.rut = it},
                label = { Text("Rut Paciente") }
            )
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {scope.launch { formViewModel.buscarPaciente() }}
            ){
                Text("Buscar Paciente")
            }
            TextField(
                value = formViewModel.nombre,
                onValueChange = { formViewModel.nombre = it},
                label = { Text("Nombre Paciente") },
                readOnly = true
            )
            Spacer(modifier = Modifier.height(50.dp))
            TextField(
                value = formViewModel.correo,
                onValueChange = { formViewModel.correo = it},
                label = { Text("Correo Paciente") },
                readOnly = true
            )
            Spacer(modifier = Modifier.height(50.dp))
        }




    }
}
