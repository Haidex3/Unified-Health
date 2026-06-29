package com.develop.myapplication.ui.screens.medico
/*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class HistorialItem(
    val fecha: String,
    val diagnostico: String,
    val medico: String
)

@Composable
fun HistorialPacienteScreen() {


    val historial = listOf(
        HistorialItem("2026-06-01", "Resfriado común", "Dr. Pérez"),
        HistorialItem("2026-05-20", "Control general", "Dra. Soto"),
        HistorialItem("2026-05-10", "Dolor estomacal", "Dr. Rojas")
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {


        Text("Historial Médico", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text("Nombre: Juan Pérez")
                Text("RUT: 12345678-9")
                Text("Correo: juan@test.com")
                Text("Teléfono: 123456789")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Consultas", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(10.dp))


        LazyColumn {
            items(historial) { item ->
                HistorialCard(item)
            }
        }
    }
}

@Composable
fun HistorialCard(item: HistorialItem) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text("Fecha: ${item.fecha}")
            Text("Diagnóstico: ${item.diagnostico}")
            Text("Médico: ${item.medico}")
        }
    }
}*/