package com.ihsan.mvvmallyoucanuse.core.di

import com.ihsan.mvvmallyoucanuse.ui.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ AuthViewModel(get()) }
}