package io.github.haniyehkhaksar.dbexample

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.github.haniyehkhaksar.dbexample.di.AppComponent
import io.github.haniyehkhaksar.dbexample.di.AppModule
import io.github.haniyehkhaksar.dbexample.di.DBModule
import io.github.haniyehkhaksar.dbexample.di.DaggerAppComponent
import javax.inject.Inject

class DBApp @Inject constructor(): DaggerApplication() {

    @Inject
    lateinit var appComponent: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = createAppComponent()
        appComponent.inject(this)
        return appComponent
    }

    fun createAppComponent(): AppComponent {
        return DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .dBModule(DBModule(this))
            .build()
    }
}