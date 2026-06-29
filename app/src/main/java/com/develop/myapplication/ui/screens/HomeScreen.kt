package com.develop.myapplication.ui.screens

import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.develop.myapplication.ui.navigation.CrearHospital
import com.develop.myapplication.ui.navigation.CrearMedico
import com.develop.myapplication.ui.navigation.InicioSesion
import com.develop.myapplication.ui.navigation.RegistrarPaciente
import com.develop.myapplication.ui.navigation.VerHospitales


@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Unified Health")
            Spacer(Modifier.height(24.dp))
            Button(
                onClick = { navController.navigate(InicioSesion("Medico")) },
                modifier = Modifier.fillMaxWidth().height(80.dp),
                shape = RectangleShape
            ) { Text("Ingresar como médico") }
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate(InicioSesion("Paciente")) },
                modifier = Modifier.fillMaxWidth().height(80.dp),
                shape = RectangleShape
            ) { Text("Ingresar como paciente") }
            Spacer(Modifier.height(16.dp))
            Button(onClick = { navController.navigate(CrearHospital) }, modifier = Modifier.fillMaxWidth()) { Text("Crear hospital") }
            Button(onClick = { navController.navigate(VerHospitales) }, modifier = Modifier.fillMaxWidth()) { Text("Ver hospitales") }
            Button(onClick = { navController.navigate(CrearMedico) }, modifier = Modifier.fillMaxWidth()) { Text("Crear médico") }
            Button(onClick = { navController.navigate(RegistrarPaciente) }, modifier = Modifier.fillMaxWidth()) { Text("Registrar paciente") }
        }
    }
}


