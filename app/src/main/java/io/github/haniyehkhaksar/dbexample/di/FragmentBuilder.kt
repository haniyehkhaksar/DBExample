package io.github.haniyehkhaksar.dbexample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.haniyehkhaksar.dbexample.ui.names.NamesFragment


@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract fun provideNamesFragment(): NamesFragment
}