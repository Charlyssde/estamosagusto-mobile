package com.veracruz.estamosagustoapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
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
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(top = 10.dp)
            ) {
                item {
                    MenuButton(
                        text = "Registrar un amigo",
                        icon = R.drawable.icon_friend_foreground,
                        description = "registro",
                        onClick = { navController.navigate(Destinations.Registration.route) }
                    )
                }
                item {
                    MenuButton(
                        text = "Registrar un amigo",
                        icon = R.drawable.icon_friend_foreground,
                        description = "registro",
                        onClick = { navController.navigate(Destinations.Registration.route) }
                    )
                }
                item {
                    MenuButton(
                        text = "Registrar un amigo",
                        icon = R.drawable.icon_friend_foreground,
                        description = "registro",
                        onClick = { navController.navigate(Destinations.Registration.route) }
                    )
                }
                item {
                    MenuButton(
                        text = "Registrar un amigo",
                        icon = R.drawable.icon_friend_foreground,
                        description = "registro",
                        onClick = { navController.navigate(Destinations.Registration.route) }
                    )
                }
            }
        }
    }
}