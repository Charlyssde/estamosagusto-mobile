package com.veracruz.estamosagustoapp.navigation

sealed class Destinations(
    val route : String,
){
    object Login : Destinations("login")
    object Home : Destinations("home")
    object Registration : Destinations("register")
}

