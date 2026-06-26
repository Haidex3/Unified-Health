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

@Composable
fun RegistrarPacienteScreen(
    onGuardarClick: (Paciente) -> Unit,
    onCancelarClick: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var RUT by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var hospitalId by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Registrar Nuevo Paciente") }) }
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
            OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Contraseña") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = hospitalId.toString(), onValueChange = { hospitalId = it.toInt() }, label = { Text("Hospital ID") }, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                OutlinedButton(onClick = onCancelarClick, modifier = Modifier.weight(1f)) { Text("Cancelar") }
                Button(onClick = { onGuardarClick(Paciente(nombre = nombre, correo = correo, RUT = RUT, sexo = sexo, celular = celular.toInt(), password = password, hospitalId = hospitalId)) }, modifier = Modifier.weight(1f)) { Text("Guardar") }
            }
        }
    }
}