package com.veracruz.estamosagustoapp.domain.repository

import com.veracruz.estamosagustoapp.domain.model.UserModel
import com.veracruz.estamosagustoapp.data.Result

interface UserRepository {
    suspend fun saveUser(userModel: UserModel) : Result<Unit>
    suspend fun getCities()
}