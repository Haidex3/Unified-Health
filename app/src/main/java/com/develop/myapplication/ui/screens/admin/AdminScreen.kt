package com.develop.myapplication.ui.screens.admin

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
import com.develop.myapplication.ui.navigation.CrearPaciente
import com.develop.myapplication.ui.navigation.EliminarHospital
import com.develop.myapplication.ui.navigation.EliminarMedico
import com.develop.myapplication.ui.navigation.EliminarPaciente
import com.develop.myapplication.ui.navigation.VerHospitales
import com.develop.myapplication.ui.navigation.VerMedico
import com.develop.myapplication.ui.navigation.VerPaciente

@Composable
fun AdminScreen(navController: NavHostController){
    Scaffold(modifier = Modifier.fillMaxSize(),
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Hospitales
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {navController.navigate(CrearHospital)},
                modifier = Modifier.fillMaxWidth().height(70.dp),
                shape = RectangleShape
            ){
                Text("Crear Hospital")
            }
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {navController.navigate(EliminarHospital)},
                modifier = Modifier.fillMaxWidth().height(70.dp),
                shape = RectangleShape
            ){
                Text("Eliminar Hospital")
            }
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {navController.navigate(VerHospitales)},
                modifier = Modifier.fillMaxWidth().height(70.dp),
                shape = RectangleShape
            ){
                Text("Ver Hospitales")
            }

            //Medicos
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {navController.navigate(CrearMedico)},
                modifier = Modifier.fillMaxWidth().height(70.dp),
                shape = RectangleShape
            ){
                Text("Crear Medico")
            }
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {navController.navigate(EliminarMedico)},
                modifier = Modifier.fillMaxWidth().height(70.dp),
                shape = RectangleShape
            ){
                Text("Eliminar Medico")
            }
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {navController.navigate(VerMedico)},
                modifier = Modifier.fillMaxWidth().height(70.dp),
                shape = RectangleShape
            ){
                Text("Ver Medicos")
            }

            //Pacientes
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {navController.navigate(CrearPaciente)},
                modifier = Modifier.fillMaxWidth().height(70.dp),
                shape = RectangleShape
            ){
                Text("Crear Paciente")
            }
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {navController.navigate( EliminarPaciente)},
                modifier = Modifier.fillMaxWidth().height(70.dp),
                shape = RectangleShape
            ){
                Text("Eliminar Paciente")
            }
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {navController.navigate(VerPaciente)},
                modifier = Modifier.fillMaxWidth().height(70.dp),
                shape = RectangleShape
            ){
                Text("Ver Pacientes")
            }
        }
    }
}

