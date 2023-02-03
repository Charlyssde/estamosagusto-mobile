package com.veracruz.estamosagustoapp.presentation.login

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.veracruz.estamosagustoapp.R
import com.veracruz.estamosagustoapp.datastore.StoreData
import com.veracruz.estamosagustoapp.domain.model.LoginModel
import com.veracruz.estamosagustoapp.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    val state : MutableState<LoginState> = mutableStateOf(LoginState())
    fun login(username : String, password : String, context : Context ){
        val dataStore = StoreData(context = context)
        viewModelScope.launch {
            val response = loginUseCase.login(LoginModel(username = username, password = password))
            response.let {
                if(it.access_token.isNotBlank()) {
                    dataStore.saveToken(it.access_token)
                    state.value = state.value.copy(success = true)
                }
            }
        }
    }

    fun hideErrorDialog (){
        state.value = state.value.copy(success = false)
    }
}