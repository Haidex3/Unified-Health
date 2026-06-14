package com.develop.myapplication.ui.screens.hospital

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.develop.myapplication.ui.components.HospitalFormViewModel
import kotlinx.coroutines.launch

@Composable
fun CrearHospitalScreen(formViewModel: HospitalFormViewModel = hiltViewModel(), navController:
NavHostController
) {
    val scope = rememberCoroutineScope()
    Button(
        onClick = {
            scope.launch {
                formViewModel.insertarHospital()
            }
        },
    ) {
        Text("Hola")
    }
}
/*
@Composable
fun CrearHospitalScreen() {

    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var ubicacion by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    Column {

        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        OutlinedTextField(value = correo, onValueChange = { correo = it }, label = { Text("Correo") })
        OutlinedTextField(value = ubicacion, onValueChange = { ubicacion = it }, label = { Text("Ubicación") })

        Button(onClick = {
            scope.launch {
                val hospital = Hospital(nombre = nombre, correo = correo, ubicacion = ubicacion)
                NetworkModule.api.createHospital(hospital)
            }
        }) {
            Text("Guardar Hospital")
        }
    }
}
 */