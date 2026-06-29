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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.develop.myapplication.ui.viewmodel.HospitalFormViewModel
import kotlinx.coroutines.launch

@Composable
fun EliminarHospitalScreen(
    formViewModel: HospitalFormViewModel = hiltViewModel(),
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
                value = formViewModel.nombre,
                onValueChange = { formViewModel.nombre = it },
                label = { Text("Nombre Hospital") }
            )

            Button(
                onClick = {
                    scope.launch {
                        formViewModel.eliminarHospital(formViewModel.nombre)
                    }
                },
            ) {
                Text("Eliminar Hospital")
            }
        }
    }
}
