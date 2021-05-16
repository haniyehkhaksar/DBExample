package io.github.haniyehkhaksar.dbexample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.haniyehkhaksar.dbexample.ui.main.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}
