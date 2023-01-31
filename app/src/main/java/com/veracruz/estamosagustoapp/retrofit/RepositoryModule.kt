package com.veracruz.estamosagustoapp.retrofit

import com.veracruz.estamosagustoapp.data.UserServiceImpl
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
}