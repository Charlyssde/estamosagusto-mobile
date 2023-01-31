package com.veracruz.estamosagustoapp.domain.model

data class CityModel (
    val id : Int? = 0,
    val entity : String = "",
    val nameEntity : String = "",
    val district : String = "",
    val city : String = "",
    val nameCity : String = "",
    val deleted : Boolean = false
)