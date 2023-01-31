package com.veracruz.estamosagustoapp.presentation.register

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    fun register (name : String, lastname : String, secondLastname : String, dateOfBirth : String, phone : String,
        mobile : String, gender : String, ethnicOrigin : String, ineCode : String, occupation : String, scholarship : String,
        section : String, city : String, email: String, hobby : String) {

        state.value.copy(0, name, lastname, secondLastname, dateOfBirth, phone, mobile, gender, ethnicOrigin, scholarship, occupation, ineCode)

        viewModelScope.launch {
            //insertUserUseCase.getAllCities()
            insertUserUseCase.invoke(
                userModel = UserModel(
                    name = name,
                    firstLastname = lastname,
                    secondLastname = secondLastname,
                    birthDate = formatDate(dateOfBirth),
                    phone = phone,
                    mobile = mobile,
                    gender = gender,
                    ethnicOrigin = ethnicOrigin,
                    ineCode = ineCode,
                    occupation = occupation,
                    scholarship = scholarship,
                    section = section,
                    city = state.value.city,
                    email = email,
                    hobby = hobby
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