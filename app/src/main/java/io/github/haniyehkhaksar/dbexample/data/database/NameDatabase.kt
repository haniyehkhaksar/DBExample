package io.github.haniyehkhaksar.dbexample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.haniyehkhaksar.dbexample.data.datamodel.NameEntity

@Database(entities = [NameEntity::class], version = 1, exportSchema = false)
internal abstract class NameDatabase : RoomDatabase() {

    abstract fun nameDao(): NameDao
}