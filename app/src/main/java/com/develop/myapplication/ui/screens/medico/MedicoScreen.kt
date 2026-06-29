package com.develop.myapplication.ui.screens.medico

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.develop.myapplication.ui.navigation.EliminarHospital
import com.develop.myapplication.ui.navigation.VerHospitales
import com.develop.myapplication.ui.navigation.VerMedico

@Composable
fun MedicoScreen(navController: NavHostController){
    Scaffold(modifier = Modifier.fillMaxSize(),
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(50.dp))
            Button(
                onClick = {navController.navigate(VerMedico)},
                modifier = Modifier.fillMaxWidth().height(100.dp),
                shape = RectangleShape
            ){
                Text("Ver Medicos")
            }
            Spacer(Modifier.height(50.dp))
            Button(
                onClick = {navController.navigate(CrearMedico)},
                modifier = Modifier.fillMaxWidth().height(100.dp),
                shape = RectangleShape
            ){
                Text("Crear Medico")
            }
            Button(
                onClick = {navController.navigate(EliminarHospital)},
                modifier = Modifier.fillMaxWidth().height(100.dp),
                shape = RectangleShape
            ){
                Text("Eliminar Medico")
            }
        }
    }
}

