package com.develop.myapplication.ui.screens.medico

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.develop.myapplication.ui.model.Medico
import androidx.compose.runtime.setValue

@Composable
fun ModificarMedicoScreen(
    medico: Medico, // Recibe obligatoriamente el médico que se va a editar
    onActualizarClick: (Medico) -> Unit,
    onCancelarClick: () -> Unit
) {
    var nombre by remember { mutableStateOf(medico.nombre) }
    var correo by remember { mutableStateOf(medico.correo) }
    var RUT by remember { mutableStateOf(medico.RUT) }
    var password by remember { mutableStateOf(medico.password) }
    var celular by remember { mutableStateOf(medico.celular) }
    var hospitalId by remember { mutableStateOf(medico.hospitalId) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Modificar Datos del Médico") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre del Médico") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = correo, onValueChange = { correo = it }, label = { Text("Especialidad") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = RUT, onValueChange = { RUT = it }, label = { Text("Nº Licencia / Colegiatura") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Correo Electrónico") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = celular, onValueChange = { celular = it }, label = { Text("Celular") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = hospitalId.toString(), onValueChange = { hospitalId = it.toInt() }, label = { Text("Hospital ID") }, modifier = Modifier.fillMaxWidth())



            Spacer(modifier = Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                OutlinedButton(onClick = onCancelarClick, modifier = Modifier.weight(1f)) { Text("Cancelar") }
                Button(onClick = { onActualizarClick(medico.copy(nombre = nombre, correo = correo, RUT = RUT, password = password, celular = celular.toInt(), hospitalId = hospitalId)) }, modifier = Modifier.weight(1f)) { Text("Actualizar") }
            }
        }
    }
}