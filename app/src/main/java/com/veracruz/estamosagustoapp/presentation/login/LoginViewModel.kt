package com.veracruz.estamosagustoapp.presentation.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.veracruz.estamosagustoapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val state : MutableState<LoginState> = mutableStateOf(LoginState())

    fun login(username : String, password : String){
        //TODO: Conexión al servicio de Login
        val errorMessage = if(username.isBlank() || password.isBlank()){
            R.string.input_field
        }else{
            null
        }
        errorMessage?.let {
            state.value = state.value.copy(
                errorMessage = it
            )
            return
        }

        viewModelScope.launch {
            delay(2000)
            state.value = state.value.copy(username = username, password = password)
            state.value = state.value.copy(success = true)

        }
    }

    fun hideErrorDialog (){
        state.value = state.value.copy(errorMessage = null)
    }
}