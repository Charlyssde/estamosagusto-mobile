package com.veracruz.estamosagustoapp.retrofit

import com.veracruz.estamosagustoapp.data.services.LoginServiceImpl
import com.veracruz.estamosagustoapp.data.services.CityServiceImpl
import com.veracruz.estamosagustoapp.data.services.UserServiceImpl
import com.veracruz.estamosagustoapp.domain.repository.CityRepository
import com.veracruz.estamosagustoapp.domain.repository.LoginRepository
import com.veracruz.estamosagustoapp.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepository(impl : UserServiceImpl) : UserRepository

    @Binds
    abstract fun bindCityRepository(impl : CityServiceImpl) : CityRepository

    @Binds
    abstract fun bindLoginRepository(impl : LoginServiceImpl) : LoginRepository

}