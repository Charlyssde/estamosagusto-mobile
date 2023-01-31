package com.veracruz.estamosagustoapp.data

import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.ui.platform.LocalContext
import com.veracruz.estamosagustoapp.R
import com.veracruz.estamosagustoapp.domain.model.UserModel
import com.veracruz.estamosagustoapp.data.Result
import com.veracruz.estamosagustoapp.domain.model.CityModel
import com.veracruz.estamosagustoapp.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserServiceImpl @Inject constructor(private val userApi: UserApi) : UserRepository {

    override suspend fun saveUser(userModel: UserModel) : Result<Unit> {
        Log.e("GETSIN->", userModel.toString())
        val response = try{
            userApi.saveUser(userModel)
        }catch (e : Exception){
            Log.e("GETSIN->", e.toString());
            e.printStackTrace()
            return Result.Error(message = "Ha ocurrido un error")
        }
        return Result.Success(data = response, message = "Se ha guardado con éxito" )
    }

    override suspend fun getCities() {
        try{
            val response = userApi.getCities()
            response.body()?.forEach { cityModel: CityModel -> Log.e("Model->", cityModel.toString()) }

        }catch (e : java.lang.Exception){
            Log.e("GETSIN->", e.toString())
            Log.e("GETSIN->", e.printStackTrace().toString())
        }
    }

}