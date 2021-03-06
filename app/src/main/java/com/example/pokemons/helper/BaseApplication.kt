package com.example.pokemons.helper

import android.app.Application
import com.example.pokemons.di.apiModule
import com.example.pokemons.di.mainActivityViewModel
import com.example.pokemons.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    apiModule,
                    repositoryModule,
                    mainActivityViewModel
                )
            )
        }
    }
}