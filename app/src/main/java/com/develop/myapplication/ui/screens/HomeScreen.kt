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
import com.develop.myapplication.ui.navigation.HospitalPantalla
import com.develop.myapplication.ui.navigation.InicioSesion
import com.develop.myapplication.ui.navigation.MedicoPantalla
import com.develop.myapplication.ui.navigation.PacientePantalla

@Composable
fun HomeScreen(navController: NavHostController){
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
                onClick = {navController.navigate(MedicoPantalla)},
                modifier = Modifier.fillMaxWidth().height(100.dp),
                shape = RectangleShape
            ){
                Text("Medico")
            }
            Spacer(Modifier.height(50.dp))
            Button(
                onClick = {navController.navigate(PacientePantalla)},
                modifier = Modifier.fillMaxWidth().height(100.dp),
                shape = RectangleShape
            ){
                Text("Paciente")
            }
            Button(
                onClick = {navController.navigate(InicioSesion)},
                modifier = Modifier.fillMaxWidth().height(100.dp),
                shape = RectangleShape
            ){
                Text("Hospital")
            }
        }
    }
}

