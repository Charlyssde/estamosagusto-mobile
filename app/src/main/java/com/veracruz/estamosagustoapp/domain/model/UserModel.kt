package com.veracruz.estamosagustoapp.domain.model

data class UserModel(
    val id : Int? = 0,
    val name : String = "",
    val firstLastname : String = "",
    val secondLastname : String = "",
    val birthDate : String = "",
    val phone : String = "",
    val mobile : String = "",
    val gender : String = "",
    val ethnicOrigin : String = "",
    val scholarship : String = "",
    val occupation : String = "",
    val ineCode : String = "",
    val section : String = "",
    val city : CityModel = CityModel(id=207, entity="30.0", nameEntity="VERACRUZ", district="20.0", city="121.0", nameCity="OTEAPAN", deleted=false),
    val email : String = "",
    val hobby : String = ""
)
