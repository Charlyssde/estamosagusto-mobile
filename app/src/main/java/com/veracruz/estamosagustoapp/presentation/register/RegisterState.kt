package com.veracruz.estamosagustoapp.presentation.register

data class RegisterState(
    val id : Int? = 0,
    val name : String = "",
    val lastname : String = "",
    val secondLastname : String = "",
    val dateOfBirth : String = "",
    val phone : String = "",
    val mobile : String = "",
    val gender : String = "",
    val ethnicOrigin : String = "",
    val scholarship : String = "",
    val occupation : String = "",
    val ineCode : String = "",
    val section : String = "",
    val city : String = "",
    val email : String = ""
)
