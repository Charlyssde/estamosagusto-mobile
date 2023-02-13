package com.veracruz.estamosagustoapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Details
import androidx.compose.material.icons.filled.Gesture
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.People
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.veracruz.estamosagustoapp.presentation.components.Header
import com.veracruz.estamosagustoapp.presentation.components.MenuButton
import com.veracruz.estamosagustoapp.R
import com.veracruz.estamosagustoapp.navigation.Destinations
import com.veracruz.estamosagustoapp.presentation.components.TopBar

@Composable
fun HomeScreen(
    text: String,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopBar(text = "¿Qué deseas hacer?")
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(15.dp).fillMaxSize()
            ) {
                item {
                    MenuButton(
                        text = "Registrar un amigo",
                        icon = Icons.Default.People,
                        description = "Registro",
                        onClick = { navController.navigate(Destinations.Registration.route) }
                    )
                }
                item {
                    MenuButton(
                        text = "Hacer otra cosa",
                        icon = Icons.Default.Language,
                        description = "Otra cosa",
                        onClick = { navController.navigate(Destinations.Registration.route) }
                    )
                }
                item {
                    MenuButton(
                        text = "Algo extra",
                        icon = Icons.Default.Gesture,
                        description = "Algo extra",
                        onClick = { navController.navigate(Destinations.CameraUI.route) }
                    )
                }
            }
        }
    }
}