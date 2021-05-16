package io.github.haniyehkhaksar.dbexample.data.database

import androidx.room.*
import io.github.haniyehkhaksar.dbexample.data.datamodel.NameEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
interface NameDao {

    @Transaction
    @Query("SELECT * FROM names")
    fun getAll(): Flow<List<NameEntity>>

    fun getDistinctAll(): Flow<List<NameEntity>> = getAll().distinctUntilChanged()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertName(names: NameEntity)
}