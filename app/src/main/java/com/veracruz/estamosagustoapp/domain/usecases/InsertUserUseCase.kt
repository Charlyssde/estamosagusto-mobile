package com.veracruz.estamosagustoapp.domain.usecases

import com.veracruz.estamosagustoapp.domain.model.UserModel
import com.veracruz.estamosagustoapp.domain.repository.UserRepository
import javax.inject.Inject
import com.veracruz.estamosagustoapp.data.Result

class InsertUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke ( userModel : UserModel ) : Result<Unit>{
        return repository.saveUser(userModel = userModel);
    }

    suspend fun getAllCities () {
        repository.getCities()
    }

}