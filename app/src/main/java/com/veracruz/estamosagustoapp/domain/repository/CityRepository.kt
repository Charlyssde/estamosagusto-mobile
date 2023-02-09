package com.veracruz.estamosagustoapp.domain.repository

import com.veracruz.estamosagustoapp.domain.model.CityModel

interface CityRepository {
    suspend fun getCities() : List<CityModel>

}