package com.develop.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.develop.myapplication.ui.screens.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object Home

@Composable
fun Navigation(){
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Home){
        composable<Home>{
            HomeScreen(navController = navController)
        }
    }
}