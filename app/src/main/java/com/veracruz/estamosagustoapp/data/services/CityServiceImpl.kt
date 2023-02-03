package com.veracruz.estamosagustoapp.data.services

import android.util.Log
import com.veracruz.estamosagustoapp.data.Api
import com.veracruz.estamosagustoapp.domain.model.CityModel
import com.veracruz.estamosagustoapp.domain.repository.CityRepository
import javax.inject.Inject

class CityServiceImpl @Inject constructor(private val api : Api) : CityRepository {
    override suspend fun getCities(): List<CityModel> {
        try{
            val response = api.getCities()
            response.body()?.forEach { cityModel: CityModel -> Log.e("Model->", cityModel.toString()) }
            return response.body() ?: emptyList()
        }catch (e : java.lang.Exception){
            Log.e("GETSIN->", e.toString())
            Log.e("GETSIN->", e.printStackTrace().toString())
        }
        return emptyList()
    }
}