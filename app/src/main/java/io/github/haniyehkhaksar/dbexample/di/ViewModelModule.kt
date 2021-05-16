package io.github.haniyehkhaksar.dbexample.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.github.haniyehkhaksar.dbexample.di.ViewModelFactory


@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}