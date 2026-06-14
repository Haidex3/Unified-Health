package com.develop.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import com.develop.myapplication.ui.screens.HomeScreen
import com.develop.myapplication.ui.screens.hospital.CrearHospitalScreen

@Serializable
object Home

@Serializable
object CrearHospital

@Composable
fun Navigation(){
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = CrearHospital){
        composable<Home>{
            HomeScreen(navController = navController)
        }
        composable<CrearHospital>{
            CrearHospitalScreen(navController = navController)
        }
    }
}