package io.github.haniyehkhaksar.dbexample.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.github.haniyehkhaksar.dbexample.data.database.NameDao
import io.github.haniyehkhaksar.dbexample.data.database.NameDatabase
import javax.inject.Singleton

@Module
class DBModule constructor(private val appContext: Context) {

    @Provides
    @Singleton
    internal fun provideDatabase(): NameDatabase {
        return Room.databaseBuilder(appContext, NameDatabase::class.java, "names.db").build()
    }

    @Provides
    @Reusable
    internal fun provideNameDao(database: NameDatabase): NameDao = database.nameDao()

}
