package com.veracruz.estamosagustoapp.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.veracruz.estamosagustoapp.presentation.login.LoginScreen
import com.veracruz.estamosagustoapp.presentation.login.LoginViewModel
import com.veracruz.estamosagustoapp.presentation.register.RegisterScreen
import com.veracruz.estamosagustoapp.presentation.register.RegisterViewModel

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.Login.route) {
        composable(Destinations.Login.route) {
            val context = LocalContext.current
            val viewModel : LoginViewModel = hiltViewModel()
            if(viewModel.state.value.success){
                Toast.makeText(context, "Ingresando", Toast.LENGTH_SHORT).show()
                LaunchedEffect(key1 = Unit){
                    navController.navigate(Destinations.Registration.route){
                        popUpTo(Destinations.Login.route){
                            inclusive = true
                        }
                    }
                }
            }else{
                if(viewModel.state.value.username.isNotBlank() && viewModel.state.value.password.isNotBlank()) Toast.makeText(context, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
                LoginScreen(
                    state = viewModel.state.value,
                    onLogin = viewModel::login,
                    onDismissDialog = viewModel::hideErrorDialog
                )
            }
        }

        composable(
            Destinations.Registration.route
        ) {
                val viewModel : RegisterViewModel = hiltViewModel()
                RegisterScreen(
                    state = viewModel.state.value,
                    onClick = viewModel::register)
        }
    }
}