package com.example.diceroller.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.diceroller.screens.Screen1
import com.example.diceroller.screens.Screen2
import com.example.diceroller.screens.Screen3
import com.example.diceroller.screens.Screen4

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost (
        navController = navController,
        startDestination = AppRoutes.Screen1.route){
        composable(route = AppRoutes.Screen1.route){
            Screen1(navController)
        }
        composable(route = AppRoutes.Screen2.route){
            Screen2(navController)
        }
        composable(route = AppRoutes.Screen3.route){
            Screen3(navController)
        }
        composable(route = AppRoutes.Screen4.route){
            Screen4(navController)
        }
    }
}