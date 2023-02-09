package com.veracruz.estamosagustoapp.data.services

import android.util.Log
import com.veracruz.estamosagustoapp.data.Api
import com.veracruz.estamosagustoapp.domain.model.LoginModel
import com.veracruz.estamosagustoapp.domain.model.TokenModel
import com.veracruz.estamosagustoapp.domain.repository.LoginRepository
import javax.inject.Inject

class LoginServiceImpl @Inject constructor(private val api : Api) : LoginRepository {

    override suspend fun login(loginModel: LoginModel) : TokenModel {
        try{
            val response = api.login(loginModel);
            Log.e("Result->", response.toString())
            return response;
        } catch (e : Exception){
            Log.e("Exception->", e.toString());
            e.message?.let{
                Log.e("Exception->", it);

            }
        }
        return TokenModel()
    }

}