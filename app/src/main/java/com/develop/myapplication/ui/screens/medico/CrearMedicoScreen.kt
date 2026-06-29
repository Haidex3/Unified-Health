package com.develop.myapplication.ui.screens.medico

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.develop.myapplication.di.DataBaseModule
import com.develop.myapplication.ui.model.Medico
import com.develop.myapplication.ui.navigation.VerHospitales
import kotlinx.coroutines.launch


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.develop.myapplication.ui.components.MedicoViewModel

@Composable
fun CrearMedicoScreen(
    navController: NavHostController? = null,
    viewModel: MedicoViewModel = hiltViewModel()
) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Crear médico")
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(value = viewModel.nombre, onValueChange = { viewModel.nombre = it }, label = { Text("Nombre") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = viewModel.correo, onValueChange = { viewModel.correo = it }, label = { Text("Correo") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = viewModel.rut, onValueChange = { viewModel.rut = it }, label = { Text("RUT") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = viewModel.password, onValueChange = { viewModel.password = it }, label = { Text("Contraseña") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = viewModel.celular, onValueChange = { viewModel.celular = it }, label = { Text("Celular") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = viewModel.hospitalId, onValueChange = { viewModel.hospitalId = it.filter(Char::isDigit) }, label = { Text("Hospital ID") }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(16.dp))
            Button(onClick = { viewModel.insertarMedico() }, modifier = Modifier.fillMaxWidth()) { Text("Guardar médico") }
            viewModel.mensaje?.let { Text(it) }
        }
    }
}