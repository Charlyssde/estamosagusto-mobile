package com.veracruz.estamosagustoapp.data

import android.util.Log
import com.veracruz.estamosagustoapp.domain.model.UserModel
import com.veracruz.estamosagustoapp.domain.model.CityModel
import com.veracruz.estamosagustoapp.domain.repository.UserRepository
import javax.inject.Inject

class UserServiceImpl @Inject constructor(private val api: Api) : UserRepository {

    override suspend fun saveUser(userModel: UserModel) : Result<Unit> {
        Log.e("GETSIN->", userModel.toString())
        val response = try{
            api.saveUser(userModel)
        }catch (e : Exception){
            Log.e("GETSIN->", e.toString());
            e.printStackTrace()
            return Result.Error(message = "Ha ocurrido un error")
        }
        return Result.Success(data = response, message = "Se ha guardado con éxito" )
    }

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