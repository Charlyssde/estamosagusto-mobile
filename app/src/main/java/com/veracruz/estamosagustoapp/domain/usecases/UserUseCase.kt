package com.veracruz.estamosagustoapp.domain.usecases

import com.veracruz.estamosagustoapp.domain.model.UserModel
import com.veracruz.estamosagustoapp.domain.repository.UserRepository
import javax.inject.Inject
import com.veracruz.estamosagustoapp.data.Result
import com.veracruz.estamosagustoapp.domain.model.CityModel

class UserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke ( userModel : UserModel ) : Result<Unit>{
        return repository.saveUser(userModel = userModel);
    }

}