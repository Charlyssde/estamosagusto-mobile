package com.veracruz.estamosagustoapp.domain.usecases

import com.veracruz.estamosagustoapp.domain.model.CityModel
import com.veracruz.estamosagustoapp.domain.repository.CityRepository
import javax.inject.Inject

class CityUseCase @Inject constructor(val repository: CityRepository) {

    suspend fun getAllCities () : List<CityModel> {
        return repository.getCities()
    }

}