package com.veracruz.estamosagustoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.veracruz.estamosagustoapp.navigation.Destinations
import com.veracruz.estamosagustoapp.navigation.NavigationHost
import com.veracruz.estamosagustoapp.presentation.home.HomeScreen
import com.veracruz.estamosagustoapp.presentation.login.LoginScreen
import com.veracruz.estamosagustoapp.presentation.login.LoginViewModel
import com.veracruz.estamosagustoapp.presentation.register.RegisterScreen
import com.veracruz.estamosagustoapp.presentation.register.RegisterViewModel
import com.veracruz.estamosagustoapp.ui.theme.EstamosAgustoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxWithConstraints() {
                EstamosAgustoAppTheme {
                    NavigationHost()
                }
            }
        }
    }
}