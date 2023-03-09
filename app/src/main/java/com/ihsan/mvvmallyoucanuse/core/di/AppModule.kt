package com.ihsan.mvvmallyoucanuse.core.di


import com.ihsan.mvvmallyoucanuse.core.data.source.local.LocalDataSource
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.RemoteDataSource
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.network.ApiConfig
import org.koin.dsl.module

val appModule =  module {
    single { ApiConfig.provideApiService }
    single { RemoteDataSource(get()) }
    single { LocalDataSource() }
}