package com.veracruz.estamosagustoapp.data

import com.veracruz.estamosagustoapp.domain.model.CityModel
import com.veracruz.estamosagustoapp.domain.model.LoginModel
import com.veracruz.estamosagustoapp.domain.model.TokenModel
import com.veracruz.estamosagustoapp.domain.model.UserModel
import com.veracruz.estamosagustoapp.presentation.login.LoginState
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @POST("/register")
    suspend fun saveUser( @Body user: UserModel)

    @POST("/auth")
    suspend fun login(@Body login : LoginModel) : TokenModel

    @GET("/city")
    suspend fun getCities() : Response<List<CityModel>>

}