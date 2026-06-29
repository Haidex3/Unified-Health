package com.develop.myapplication.ui.screens.hospital

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.develop.myapplication.ui.model.Hospital
import com.develop.myapplication.ui.viewmodel.HospitalFormViewModel
import com.develop.myapplication.ui.navigation.VerHospitales
import com.develop.myapplication.ui.viewmodel.PacienteViewModel
import kotlinx.coroutines.launch

@Composable
fun CrearPacienteScreen(
    formViewModel: PacienteViewModel = hiltViewModel(),
    formViewModelHospital: HospitalFormViewModel = hiltViewModel(),
    navController: NavHostController,
    nombre:String
) {
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = formViewModel.nombre,
                onValueChange = { formViewModel.nombre = it },
                label = { Text("Nombre Paciente") }
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = formViewModel.rut,
                onValueChange = { formViewModel.rut = it },
                label = { Text("Rut Paciente") }
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = formViewModel.password,
                onValueChange = { formViewModel.password = it },
                label = { Text("Contraseña Paciente") }
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = formViewModel.correo,
                onValueChange = { formViewModel.correo = it },
                label = { Text("Correo Paciente") }
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = formViewModel.sexo,
                onValueChange = { formViewModel.sexo = it },
                label = { Text("Sexo Paciente") }
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = formViewModel.celular,
                onValueChange = { formViewModel.celular = it },
                label = { Text("Celular Paciente") }
            )
            Spacer(modifier = Modifier.height(8.dp))


            Button(
                onClick = {
                    scope.launch {
                        formViewModel.insertarPaciente()
                    }
                },
            ) {
                Text("Crear Hospital")
            }
        }
    }
}
