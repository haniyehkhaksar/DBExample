package io.github.haniyehkhaksar.dbexample.data.repository

import io.github.haniyehkhaksar.dbexample.data.database.NameDao
import io.github.haniyehkhaksar.dbexample.data.datamodel.NameEntity
import io.github.haniyehkhaksar.dbexample.data.datamodel.toDomainModel
import io.github.haniyehkhaksar.dbexample.domain.domainmodel.Name
import io.github.haniyehkhaksar.dbexample.domain.repository.IDBRepository
import io.github.haniyehkhaksar.dbexample.utils.MyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DBRepository @Inject constructor(private val nameDao: NameDao): IDBRepository {
    override fun getNames(): Flow<MyResult<List<Name>>> {
        return nameDao.getAll().map { MyResult.Success(it.map { item -> item.toDomainModel() }) }
            .catch { MyResult.Error<Throwable>(it) }
    }

    override suspend fun insertName(name: String) {
        return nameDao.insertName(NameEntity(name = name))
    }
}