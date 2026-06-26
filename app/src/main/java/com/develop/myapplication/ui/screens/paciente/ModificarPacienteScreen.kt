package com.develop.myapplication.ui.screens.paciente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.develop.myapplication.ui.model.Paciente
import androidx.compose.runtime.getValue

@Composable
fun ModificarPacienteScreen(
    paciente: Paciente, // Recibe obligatoriamente el paciente que se va a editar
    onActualizarClick: (Paciente) -> Unit,
    onCancelarClick: () -> Unit
) {
    var nombre by remember { mutableStateOf(paciente.nombre) }
    var correo by remember { mutableStateOf(paciente.correo) }
    var RUT by remember { mutableStateOf(paciente.RUT) }
    var sexo by remember { mutableStateOf(paciente.sexo) }
    var celular by remember { mutableStateOf(paciente.celular) }
    var password by remember { mutableStateOf(paciente.password) }
    var hospitalId by remember { mutableStateOf(paciente.hospitalId) }


    Scaffold(
        topBar = { TopAppBar(title = { Text("Modificar Datos del Paciente") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre Completo") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = correo, onValueChange = { correo = it }, label = { Text("Correo Electrónico") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = RUT, onValueChange = { RUT = it }, label = { Text("RUT") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = sexo, onValueChange = { sexo = it }, label = { Text("Sexo Médico") }, modifier = Modifier.fillMaxWidth(), minLines = 3)
            OutlinedTextField(value = celular, onValueChange = { celular = it }, label = { Text("Celular") }, modifier = Modifier.fillMaxWidth())


            Spacer(modifier = Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                OutlinedButton(onClick = onCancelarClick, modifier = Modifier.weight(1f)) { Text("Cancelar") }
                Button(onClick = { onActualizarClick(paciente.copy(nombre = nombre, correo = correo, RUT = RUT, sexo = sexo, celular = celular.toInt(), password = password, hospitalId = hospitalId)) }, modifier = Modifier.weight(1f)) { Text("Actualizar") }
            }
        }
    }
}