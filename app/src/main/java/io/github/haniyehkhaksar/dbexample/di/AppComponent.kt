package io.github.haniyehkhaksar.dbexample.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class, ViewModelModule::class,
        DBModule::class, ActivityBuilder::class, FragmentBuilder::class]
)
interface AppComponent : AndroidInjector<DaggerApplication>