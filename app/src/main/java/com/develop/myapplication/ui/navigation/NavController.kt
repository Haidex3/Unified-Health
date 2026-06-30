package com.develop.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.develop.myapplication.ui.model.Medico
import kotlinx.serialization.Serializable
import com.develop.myapplication.ui.screens.HomeScreen
import com.develop.myapplication.ui.screens.InicioSesionScreen
import com.develop.myapplication.ui.screens.admin.AdminScreen
import com.develop.myapplication.ui.screens.hospital.CrearCitaMedicoScreen
import com.develop.myapplication.ui.screens.hospital.CrearHospitalScreen
import com.develop.myapplication.ui.screens.hospital.CrearPacienteScreen
import com.develop.myapplication.ui.screens.hospital.EliminarHospitalScreen
import com.develop.myapplication.ui.screens.hospital.HospitalScreen
import com.develop.myapplication.ui.screens.hospital.VerHospitalesScreen
import com.develop.myapplication.ui.screens.medico.BuscarPacienteScreen
import com.develop.myapplication.ui.screens.medico.CrearMedicoScreen
import com.develop.myapplication.ui.screens.medico.EliminarMedicoScreen
import com.develop.myapplication.ui.screens.medico.MedicoScreen
import com.develop.myapplication.ui.screens.medico.VerMedicoScreen
import com.develop.myapplication.ui.screens.paciente.EliminarPacienteScreen
//import com.develop.myapplication.ui.screens.medico.VerCitasMedicoScreen
import com.develop.myapplication.ui.screens.paciente.PacienteScreen
import com.develop.myapplication.ui.screens.paciente.VerPacienteScreen

@Serializable
object Home
@Serializable
object MedicoPantalla
@Serializable
object PacientePantalla
@Serializable
object AdminPantalla



//Pantallas Hospital------------------------------------------------------------
@Serializable
object CrearHospital
@Serializable
object VerHospitales
@Serializable
object EliminarHospital


//Pantallas Medico------------------------------------------------------------
@Serializable
object VerCitasMedico
@Serializable
object CrearMedico
@Serializable
object VerMedico
@Serializable
object EliminarMedico
@Serializable
object VerPacienteMedico
//Paciente ------------------------------------------------------------
@Serializable
object CrearPaciente
@Serializable
object EliminarPaciente
@Serializable
object VerPaciente



//---------------------------------------------------------------------
@Serializable
data class InicioSesion(val tipo_sesion: String)
@Serializable
object CrearCitaMedico

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home){
        composable<Home>{
            HomeScreen(navController = navController)
        }

        //Pantallas de inicio
        composable<MedicoPantalla> {
            MedicoScreen(navController = navController)
        }
        composable<PacientePantalla> {
            PacienteScreen(navController = navController)
        }
        composable<AdminPantalla> {
            AdminScreen(navController = navController)
        }

        //Pantallas de Medico----------------------------------------------------
        composable<CrearMedico> {
            CrearMedicoScreen(navController = navController)
        }
        composable<VerMedico>{
            VerMedicoScreen()
        }
        composable<EliminarMedico> {
            EliminarMedicoScreen(navController = navController)
        }
        composable<VerPacienteMedico> {
            BuscarPacienteScreen()
        }
        // composable<VerCitasMedico> {
        //    VerCitasMedicoScreen(navController = navController)
       // }


        //Pantallas de Paciente ----------------------------------------------------
        composable<CrearPaciente> {
            CrearPacienteScreen(navController=navController)
        }
        composable<EliminarPaciente> {
            EliminarPacienteScreen(navController=navController)
        }
        composable<VerPaciente> {
            VerPacienteScreen()
        }



        // Pantallas de Hospital----------------------------------------------------
        composable<CrearHospital>{
            CrearHospitalScreen(navController = navController)
        }
        composable<VerHospitales> {
            VerHospitalesScreen()

        }
        composable<EliminarHospital>{
            EliminarHospitalScreen(navController=navController)
        }


        composable<InicioSesion> {backstackEntry->
            val args = backstackEntry.toRoute<InicioSesion>()
            InicioSesionScreen(navController = navController,   tipo_sesion = args.tipo_sesion)
        }
        composable<CrearCitaMedico>{
            CrearCitaMedicoScreen(navController=navController)
        }

    }
}

