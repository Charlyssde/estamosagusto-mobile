package com.veracruz.estamosagustoapp.presentation.register

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.veracruz.estamosagustoapp.domain.model.CityModel
import com.veracruz.estamosagustoapp.domain.model.UserModel
import com.veracruz.estamosagustoapp.domain.usecases.InsertUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val insertUserUseCase: InsertUserUseCase
) : ViewModel() {

    val state : MutableState<UserModel> = mutableStateOf(UserModel())

    suspend fun getAllCities() : List<CityModel> {
        return insertUserUseCase.getAllCities()?: emptyList();
    }

    fun register (name : String, firstLastname : String, secondLastname : String, birthDate : String, phone : String,
        mobile : String, gender : String, ethnicOrigin : String, ineCode : String, occupation : String, scholarship : String,
        section : String, city : CityModel, email: String, hobby : String) {

        state.value = state.value.copy(id = 0, name = name, firstLastname = firstLastname,secondLastname = secondLastname, birthDate = birthDate, phone = phone,
            mobile = mobile, gender = gender, ethnicOrigin = ethnicOrigin, scholarship = scholarship,occupation = occupation, ineCode = ineCode, city = city,
        email = email, hobby = hobby) //TODO: Asignar la city

        Log.e("GETSIN->", state.value.toString())
        viewModelScope.launch {
            insertUserUseCase.invoke(
                userModel = UserModel(
                    name = state.value.name,
                    firstLastname = state.value.firstLastname,
                    secondLastname = state.value.secondLastname,
                    birthDate = formatDate(state.value.birthDate),
                    phone = state.value.phone,
                    mobile = state.value.mobile,
                    gender = state.value.gender,
                    ethnicOrigin = state.value.ethnicOrigin,
                    ineCode = state.value.ineCode,
                    occupation = state.value.occupation,
                    scholarship = state.value.scholarship,
                    section = state.value.section,
                    city = state.value.city,
                    email = state.value.email,
                    hobby = state.value.hobby
                )
            )
        }
    }

    private fun formatDate(date : String) : String{
        var response = ""

        response += date.substring(0,2) + "/" + date.substring(2, 4) + "/" + date.substring(date.length - 4, date.length);

        return response
    }

}