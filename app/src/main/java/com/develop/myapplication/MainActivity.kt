package com.develop.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.develop.myapplication.ui.model.Medico
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.composable
import com.develop.myapplication.ui.screens.medico.ModificarMedicoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aquí iniciamos la navegación de tu app
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "menu") {

        composable("menu") { /* Código de tus botones del menú */ }

        // 1. CREATE PACIENTE
        composable("registrar_paciente") {
            RegistrarPacienteScreen(
                onGuardarClick = { nuevoPaciente -> /* Guardar en BD */ },
                onCancelarClick = { navController.popBackStack() }
            )
        }

        // 2. UPDATE PACIENTE
        composable("modificar_paciente") {
            val pacienteExistente = Paciente("1", "Carlos", "30", "12345", "Ninguno")
            ModificarPacienteScreen(
                paciente = pacienteExistente,
                onActualizarClick = { pacienteEditado -> /* Actualizar en BD */ },
                onCancelarClick = { navController.popBackStack() }
            )
        }

        // 3. CREATE MÉDICO
        composable("registrar_medico") {
            RegistrarMedicoScreen(
                onGuardarClick = { nuevoMedico -> /* Guardar en BD */ },
                onCancelarClick = { navController.popBackStack() }
            )
        }

        // 4. UPDATE MÉDICO
        composable("modificar_medico") {
            val medicoExistente = Medico("1", "Dr. House", "Diagnóstico", "123-X", "house@mail.com")
            ModificarMedicoScreen(
                medico = medicoExistente,
                onActualizarClick = { medicoEditado -> /* Actualizar en BD */ },
                onCancelarClick = { navController.popBackStack() }
            )
        }
    }

// Un menú simple para probar los botones de tus 4 pantallas
@Composable
fun MenuPrincipalScreen(
    onIrARegistrarPaciente: () -> Unit,
    onIrAModificarPaciente: () -> Unit,
    onIrARegistrarMedico: () -> Unit,
    onIrAModificarMedico: () -> Unit
) {
    androidx.compose.foundation.layout.Column(
        modifier = androidx.compose.ui.Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "Menú de Gestión", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)

        androidx.compose.material3.Button(onClick = onIrARegistrarPaciente) { Text("1. Registrar Paciente") }
        androidx.compose.material3.Button(onClick = onIrAModificarPaciente) { Text("2. Modificar Paciente") }
        androidx.compose.material3.Button(onClick = onIrARegistrarMedico) { Text("3. Registrar Médico") }
        androidx.compose.material3.Button(onClick = onIrAModificarMedico) { Text("4. Modificar Médico") }
    }
}
