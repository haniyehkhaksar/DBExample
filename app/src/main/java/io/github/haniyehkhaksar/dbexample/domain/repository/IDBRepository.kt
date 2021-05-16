package io.github.haniyehkhaksar.dbexample.domain.repository

import androidx.lifecycle.LiveData
import io.github.haniyehkhaksar.dbexample.domain.domainmodel.Name
import io.github.haniyehkhaksar.dbexample.utils.MyResult
import kotlinx.coroutines.flow.Flow

interface IDBRepository {

    fun getNames(): Flow<MyResult<List<Name>>>

    suspend fun insertName(name: String)
}