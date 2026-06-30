package com.develop.myapplication.ui.screens.medico

import com.develop.myapplication.ui.viewmodel.HorarioHoraFormViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.develop.myapplication.ui.navigation.VerMedico
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date

@Composable
fun AgregarHorasScreen(
    formViewModel: HorarioHoraFormViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val scope = rememberCoroutineScope()
    val state = rememberDatePickerState()
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
                value = formViewModel.nombreMedico,
                onValueChange = { formViewModel.nombreMedico = it },
                label = { Text("Nombre Medico") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            DatePicker(state = state)


            formViewModel.fecha = state.selectedDateMillis.toString()
            Text(formViewModel.fecha)
            Button(
                onClick = {
                    scope.launch {
                        formViewModel.insertarHorario()
                    }
                },
            ) {
                Text("Añadir Hora")
            }
        }
    }
}
