package io.github.haniyehkhaksar.dbexample.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule constructor(private val appContext: Context){

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return appContext
    }

}