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

@Serializable
object Home

@Serializable
object CrearHospital
@Serializable
object VerHospitales
@Serializable
data class InicioSesion(val tipo_sesion: String)

@Composable
fun Navigation(){
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Home){
        composable<Home>{
            HomeScreen(navController = navController)
        }
        composable<CrearHospital>{
            CrearHospitalScreen(navController = navController)
        }
        composable<VerHospitales> {
            VerHospitalesScreen()

        }
        composable<InicioSesion> {backstackEntry->
            val args = backstackEntry.toRoute<InicioSesion>()
            InicioSesionScreen(navController = navController,   tipo_sesion = args.tipo_sesion)
        }
    }
}