package com.example.blogdenotas2.ui.main.views

sealed class MainDestinations (val route : String){
    object HomeScreen: MainDestinations(route = "home")
    object AddScreen : MainDestinations(route = "add")
    object UpdateScreen: MainDestinations(route = "update")
}
