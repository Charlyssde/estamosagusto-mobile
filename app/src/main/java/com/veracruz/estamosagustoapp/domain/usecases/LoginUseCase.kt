package com.veracruz.estamosagustoapp.domain.usecases

import com.veracruz.estamosagustoapp.domain.model.LoginModel
import com.veracruz.estamosagustoapp.domain.model.TokenModel
import com.veracruz.estamosagustoapp.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {

    suspend fun login (loginModel: LoginModel) : TokenModel{
        return loginRepository.login(loginModel)
    }

}