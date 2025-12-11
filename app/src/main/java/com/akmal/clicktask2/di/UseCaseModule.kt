package com.akmal.clicktask2.di

import com.akmal.clicktask2.domain.usecase.GetProductsUseCase
import com.akmal.clicktask2.domain.usecase.impl.GetProductsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetProductsUseCase(impl: GetProductsUseCaseImpl): GetProductsUseCase
}