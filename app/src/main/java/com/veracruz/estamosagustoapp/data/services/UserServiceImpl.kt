package com.veracruz.estamosagustoapp.data.services

import android.util.Log
import com.veracruz.estamosagustoapp.data.Api
import com.veracruz.estamosagustoapp.data.Result
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
        return Result.Success(data = response, message = "Se ha guardado con éxito")
    }

}