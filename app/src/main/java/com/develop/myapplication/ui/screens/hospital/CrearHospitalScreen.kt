package com.develop.myapplication.ui.screens.hospital

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.develop.myapplication.ui.model.Hospital
import com.develop.myapplication.network.NetworkModule
import kotlinx.coroutines.launch

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