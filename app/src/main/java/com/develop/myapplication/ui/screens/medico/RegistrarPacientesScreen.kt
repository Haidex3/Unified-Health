package com.develop.myapplication.ui.screens.medico

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.develop.myapplication.model.Paciente
import com.develop.myapplication.network.NetworkModule
import kotlinx.coroutines.launch

@Composable
fun RegistrarPacienteScreen() {

    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var rut by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Registrar Paciente")

        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        OutlinedTextField(value = apellido, onValueChange = { apellido = it }, label = { Text("Apellido") })
        OutlinedTextField(value = rut, onValueChange = { rut = it }, label = { Text("RUT") })
        OutlinedTextField(value = correo, onValueChange = { correo = it }, label = { Text("Correo") })
        OutlinedTextField(value = sexo, onValueChange = { sexo = it }, label = { Text("Sexo") })
        OutlinedTextField(value = celular, onValueChange = { celular = it }, label = { Text("Celular") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            scope.launch {
                try {
                    val paciente = Paciente(
                        nombre = nombre,
                        apellido = apellido,
                        rut = rut,
                        correo = correo,
                        sexo = sexo,
                        num_celular = celular
                    )

                    val response = NetworkModule.api.createPaciente(paciente)

                    println("Paciente creado: $response")

                } catch (e: Exception) {
                    println("ERROR: ${e.message}")
                }
            }
        }) {
            Text("Guardar")
        }
    }
}