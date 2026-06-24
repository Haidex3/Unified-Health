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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.develop.myapplication.di.DataBaseModule
import com.develop.myapplication.ui.model.Medico
import kotlinx.coroutines.launch
@Composable
fun CrearMedicoScreen() {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var rut by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var hospitalId by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Crear Medico")
        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        OutlinedTextField(value = correo, onValueChange = { correo = it }, label = { Text("Correo") })
        OutlinedTextField(value = rut, onValueChange = { rut = it }, label = { Text("RUT") })
        OutlinedTextField(value = celular, onValueChange = { celular = it }, label = { Text("Celular") })
        OutlinedTextField(value = hospitalId, onValueChange = { hospitalId = it }, label = { Text("ID Hospital") })
        Button(onClick = {
            scope.launch {
                try {
                    DataBaseModule.api.createDoctor(
                        Medico(nombre = nombre, correo = correo, rut = rut,
                            celular = celular, password = "", hospital_id = hospitalId.toIntOrNull() ?: 0)
                    )
                } catch (e: Exception) { /* mostrar error */ }
            }
        }) { Text("Guardar Doctor") }
    }
}