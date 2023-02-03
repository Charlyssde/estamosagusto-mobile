package com.veracruz.estamosagustoapp.domain.repository

import com.veracruz.estamosagustoapp.domain.model.UserModel
import com.veracruz.estamosagustoapp.data.Result
import com.veracruz.estamosagustoapp.domain.model.CityModel

interface UserRepository {
    suspend fun saveUser(userModel: UserModel) : Result<Unit>
}