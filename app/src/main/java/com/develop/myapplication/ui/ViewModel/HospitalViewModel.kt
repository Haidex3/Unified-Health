package com.develop.myapplication.ui.ViewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun CrearMedicoScreen(
    viewModel: MedicoViewModel,
    onMedicoCreado: () -> Unit
) {

    val state by viewModel.uiState.collectAsState()

    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var especialidad by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Crear Médico", fontSize = 26.sp)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = especialidad,
            onValueChange = { especialidad = it },
            label = { Text("Especialidad") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.crearMedico(nombre, correo, especialidad)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar Médico")
        }

        Spacer(modifier = Modifier.height(16.dp))


        if (state.isLoading) {
            CircularProgressIndicator()
        }


        state.error?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error)
        }


        state.medico?.let {
            LaunchedEffect(it) {
                onMedicoCreado()
            }
        }

        
    fun insertarHospital() {
        if (telefono.isBlank()) return

        viewModelScope.launch {
            val nuevoHospital = Hospital(
                id = 0,
                nombre = nombre,
                correo = correo,
                telefono = telefono.toInt(),
                ubicacion = ubicacion
            )
            hospitalRepository.insertarHospitalBackend(nuevoHospital)
            resetForm()
        }
    }
}