package com.veracruz.estamosagustoapp.data

import com.veracruz.estamosagustoapp.domain.model.CityModel
import com.veracruz.estamosagustoapp.domain.model.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @POST("/register")
    suspend fun saveUser( @Body user: UserModel)

    @GET("/city")
    suspend fun getCities() : Response<List<CityModel>>

}