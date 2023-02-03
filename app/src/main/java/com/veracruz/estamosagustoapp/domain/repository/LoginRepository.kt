package com.veracruz.estamosagustoapp.domain.repository

import com.veracruz.estamosagustoapp.domain.model.LoginModel
import com.veracruz.estamosagustoapp.domain.model.TokenModel

interface LoginRepository {

    suspend fun login (loginModel: LoginModel) : TokenModel

}