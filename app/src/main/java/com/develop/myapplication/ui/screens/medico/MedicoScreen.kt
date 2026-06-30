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
import com.develop.myapplication.ui.navigation.CrearCitaMedico
import com.develop.myapplication.ui.navigation.EliminarMedico
import com.develop.myapplication.ui.navigation.VerPacienteMedico

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
                onClick = {navController.navigate(VerPacienteMedico)},
                modifier = Modifier.fillMaxWidth().height(100.dp),
                shape = RectangleShape
            ){
                Text("Buscar Paciente")
            }
            Spacer(Modifier.height(50.dp))
            Button(
                onClick = {navController.navigate(CrearCitaMedico)},
                modifier = Modifier.fillMaxWidth().height(100.dp),
                shape = RectangleShape
            ){
                Text("Agendar Cita")
            }
        }
    }
}

