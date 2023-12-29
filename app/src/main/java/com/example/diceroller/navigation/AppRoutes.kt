package com.example.diceroller.navigation

sealed class AppRoutes(val route: String){
    object Screen1: AppRoutes("screen1")
    object Screen2: AppRoutes("screen2")
    object Screen3: AppRoutes("screen3")
    object Screen4: AppRoutes("screen4")
}