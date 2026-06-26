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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.develop.myapplication.ui.navigation.CrearHospital
import com.develop.myapplication.ui.navigation.VerHospitales
import com.develop.myapplication.ui.screens.hospital.CrearHospitalScreen

@Composable
fun HomeScreen(nav: NavController) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Bienvenido", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { nav.navigate("medicos") }) {
            Text("Ver Médicos")
        }

        Button(onClick = { nav.navigate("citas") }) {
            Text("Mis Citas")
        }

        Button(onClick = { nav.navigate("perfil") }) {
            Text("Perfil")
        }
    }
}
