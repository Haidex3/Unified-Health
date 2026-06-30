package com.develop.myapplication.ui.screens.medico


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
import com.develop.myapplication.ui.navigation.VerMedico
import com.develop.myapplication.ui.viewmodel.MedicoViewModel
import kotlinx.coroutines.launch

@Composable
fun CrearMedicoScreen(
    formViewModel: MedicoViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val scope = rememberCoroutineScope()
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Button(
                onClick = {
                    navController.navigate(VerMedico)
                }

            ) {
                Text("Ver Medicos")
            }
        }
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
                label = { Text("Nombre Medico") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = formViewModel.rut,
                onValueChange = { formViewModel.rut = it },
                label = { Text("RUT") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = formViewModel.correo,
                onValueChange = { formViewModel.correo = it },
                label = { Text("Correo") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = formViewModel.celular,
                onValueChange = { formViewModel.celular = it },
                label = { Text("Celular") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = formViewModel.password,
                onValueChange = { formViewModel.password = it },
                label = { Text("Contraseña") }
            )
            TextField(
                value = formViewModel.hospital,
                onValueChange = {formViewModel.hospital = it},
                label = { Text("Nombre Hospital")}
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    scope.launch {
                        formViewModel.insertarMedico()
                    }
                },
            ) {
                Text("Crear Medioc")
            }
        }
    }
}
