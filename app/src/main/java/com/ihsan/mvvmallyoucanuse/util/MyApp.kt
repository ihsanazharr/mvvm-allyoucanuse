package com.ihsan.mvvmallyoucanuse.util


import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.ihsan.mvvmallyoucanuse.core.di.appModule
import com.ihsan.mvvmallyoucanuse.core.di.repositoryModule
import com.ihsan.mvvmallyoucanuse.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)
        startKoin{
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }
}