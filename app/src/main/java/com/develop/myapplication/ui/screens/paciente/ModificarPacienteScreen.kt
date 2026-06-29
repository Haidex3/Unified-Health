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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.develop.myapplication.ui.model.Paciente

@Composable
fun ModificarPacienteScreen(
    paciente: Paciente,
    onActualizarClick: (Paciente) -> Unit,
    onCancelarClick: () -> Unit
) {
    var nombre by remember { mutableStateOf(paciente.nombre) }
    var correo by remember { mutableStateOf(paciente.correo) }
    var rut by remember { mutableStateOf(paciente.RUT) }
    var sexo by remember { mutableStateOf(paciente.sexo) }
    var celular by remember { mutableStateOf(paciente.celular) }
    var hospitalId by remember { mutableStateOf(paciente.hospitalId.toString()) }

    Scaffold { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Modificar paciente")
            OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = correo, onValueChange = { correo = it }, label = { Text("Correo") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = rut, onValueChange = { rut = it }, label = { Text("RUT") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = sexo, onValueChange = { sexo = it }, label = { Text("Sexo") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = celular, onValueChange = { celular = it }, label = { Text("Celular") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = hospitalId, onValueChange = { hospitalId = it.filter(Char::isDigit) }, label = { Text("Hospital ID") }, modifier = Modifier.fillMaxWidth())
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                OutlinedButton(onClick = onCancelarClick, modifier = Modifier.weight(1f)) { Text("Cancelar") }
                Button(
                    onClick = { onActualizarClick(paciente.copy(nombre = nombre, correo = correo, RUT = rut, sexo = sexo, celular = celular, hospitalId = hospitalId.toIntOrNull() ?: paciente.hospitalId)) },
                    modifier = Modifier.weight(1f)
                ) { Text("Actualizar") }
            }
        }
    }
}