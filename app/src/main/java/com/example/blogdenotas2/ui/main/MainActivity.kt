package com.example.blogdenotas2.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blogdenotas2.ui.main.interaction.NoteEvent
import com.example.blogdenotas2.ui.main.viewmodels.NoteViewModel
import com.example.blogdenotas2.ui.main.views.AddScreen
import com.example.blogdenotas2.ui.main.views.HomeScreen
import com.example.blogdenotas2.ui.main.views.MainDestinations
import com.example.blogdenotas2.ui.main.views.UpdateScreen
import com.example.blogdenotas2.ui.theme.BLOGDENOTAS2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BLOGDENOTAS2Theme {
                val navController = rememberNavController()
                val noteViewModel: NoteViewModel = hiltViewModel()
                NavHost(
                    navController = navController,
                    //el route
                    startDestination = MainDestinations.HomeScreen.route
                ) {
                    composable(MainDestinations.HomeScreen.route) {
                        HomeScreen(onNavigate = { screen ->
                            navigate(
                                navHostController = navController,
                                destination = screen
                            )
                        },
                            noteState = noteViewModel.state.value,
                            onSelectedNote = { note ->
                                noteViewModel.onEvent(NoteEvent.SelectNote(note = note))
                                navigate(
                                    navHostController = navController,
                                    destination = MainDestinations.UpdateScreen
                                )
                            }
                        )
                    }
                    composable(MainDestinations.AddScreen.route) {
                        AddScreen(onEvent = { event ->
                            noteViewModel.onEvent(noteEvent = event)
                        },
                            noteState = noteViewModel.state.value,
                            onNavigate = { screen ->
                                navigate(navHostController = navController, destination = screen)
                            }
                        )
                    }
                    composable(MainDestinations.UpdateScreen.route) {
                        UpdateScreen(
                            selectedNote = noteViewModel.state.value.selectedNote,
                            onNavigate = { screen ->
                                navigate(
                                    navHostController = navController,
                                    destination = screen
                                )
                            },
                            noteState = noteViewModel.state.value,
                            onEvent = { event ->
                                noteViewModel.onEvent(event)
                            }
                        )
                    }
                }
            }
        }
    }

    private fun navigate(navHostController: NavHostController, destination: MainDestinations) {
        navHostController.navigate(destination.route) {
            // Guarda el estado de una pantalla
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            //Una pantalla se instanscia = ejecuta una sola vez, para ahorrar recursos
            launchSingleTop = true
        }
    }
}


