package com.ihsan.mvvmallyoucanuse.core.di

import com.ihsan.mvvmallyoucanuse.core.data.repository.AppRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AppRepository(get(), get()) }
}