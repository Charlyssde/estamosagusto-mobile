package com.veracruz.estamosagustoapp.presentation.login

import androidx.annotation.StringRes

data class LoginState(
    val username : String = "",
    val password : String = "",
    val success : Boolean = false,
    @StringRes val errorMessage : Int? = null
)
