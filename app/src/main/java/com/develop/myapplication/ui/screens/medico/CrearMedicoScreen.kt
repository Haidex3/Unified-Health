package com.develop.myapplication.ui.screens.medico

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import com.develop.myapplication.ui.components.MedicoViewModel

@Composable
fun CrearMedicoScreen(
    viewModel: MedicoViewModel = hiltViewModel()
) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var rut by remember { mutableStateOf("") }
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
            Text("Crear Médico")
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = correo, onValueChange = { correo = it }, label = { Text("Correo") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = rut, onValueChange = { rut = it }, label = { Text("RUT") })
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
                        viewModel.registrarMedico(
                            nombre = nombre,
                            correo = correo,
                            password = password,
                            rut = rut,
                            celular = celular,
                            hospitalId = hospitalId.toIntOrNull() ?: 0
                        )
                    }
                ) {
                    Text("Guardar Doctor")
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