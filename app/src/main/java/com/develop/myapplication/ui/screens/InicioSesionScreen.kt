package com.develop.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.develop.myapplication.ui.navigation.HospitalPantalla
import com.develop.myapplication.ui.navigation.MedicoPantalla
import com.develop.myapplication.ui.navigation.PacientePantalla
import com.develop.myapplication.ui.viewmodel.AuthViewModel

@Composable
fun InicioSesionScreen(
    navController: NavHostController,
    viewModel: AuthViewModel = hiltViewModel()
) {

    LaunchedEffect(viewModel.loginSuccess) {

        if (viewModel.loginSuccess) {

            when (viewModel.userType) {

                "administrador" -> {
                    navController.navigate(HospitalPantalla) {
                        popUpTo(0)
                    }
                }

                "medico" -> {
                    navController.navigate(MedicoPantalla) {
                        popUpTo(0)
                    }
                }

                "paciente" -> {
                    navController.navigate(PacientePantalla) {
                        popUpTo(0)
                    }
                }

                else -> {
                    navController.navigate("login") {
                        popUpTo(0)
                    }
                }
            }
        }
    }

    Scaffold { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = viewModel.rut,
                onValueChange = {
                    viewModel.rut = it
                    viewModel.clearError()
                },
                label = { Text("RUT") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = viewModel.password,
                onValueChange = {
                    viewModel.password = it
                    viewModel.clearError()
                },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { viewModel.login() },
                modifier = Modifier.fillMaxWidth(),
                enabled = !viewModel.isLoading
            ) {
                Text("Ingresar")
            }

            if (viewModel.isLoading) {
                Spacer(modifier = Modifier.height(16.dp))
                CircularProgressIndicator()
            }

            viewModel.errorMessage?.let {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}