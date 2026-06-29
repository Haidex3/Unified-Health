package com.develop.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import com.develop.myapplication.ui.screens.HomeScreen
import com.develop.myapplication.ui.screens.InicioSesionScreen
import com.develop.myapplication.ui.screens.hospital.CrearHospitalScreen
import com.develop.myapplication.ui.screens.hospital.VerHospitalesScreen
import com.develop.myapplication.ui.screens.medico.CitasMedicoScreen
import com.develop.myapplication.ui.screens.medico.CrearMedicoScreen
import com.develop.myapplication.ui.screens.paciente.RegistrarPacienteScreen

@Serializable object Home
@Serializable object CrearHospital
@Serializable object VerHospitales
@Serializable object CrearMedico
@Serializable object RegistrarPaciente
@Serializable data class InicioSesion(val tipoSesion: String)
@Serializable data class CitasMedico(val medicoId: Int)

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home> { HomeScreen(navController = navController) }
        composable<CrearHospital> { CrearHospitalScreen(navController = navController) }
        composable<VerHospitales> { VerHospitalesScreen(navController = navController) }
        composable<CrearMedico> { CrearMedicoScreen(navController = navController) }
        composable<RegistrarPaciente> { RegistrarPacienteScreen(navController = navController) }
        composable<InicioSesion> { backStackEntry ->
            val args = backStackEntry.toRoute<InicioSesion>()
            InicioSesionScreen(navController = navController, tipoSesion = args.tipoSesion)
        }
        composable<CitasMedico> { backStackEntry ->
            val args = backStackEntry.toRoute<CitasMedico>()
            CitasMedicoScreen(navController = navController, medicoId = args.medicoId)
        }
    }
}