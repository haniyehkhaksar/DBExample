package io.github.haniyehkhaksar.dbexample.data.database

import androidx.room.*
import io.github.haniyehkhaksar.dbexample.data.datamodel.NameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NameDao {

    @Transaction
    @Query("SELECT * FROM names")
    suspend fun getAll(): List<NameEntity>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertName(names: NameEntity)
}