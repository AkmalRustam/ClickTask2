package com.akmal.clicktask2.di

import com.akmal.clicktask2.data.remote.source.RemoteDataSource
import com.akmal.clicktask2.data.remote.source.impl.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource
}