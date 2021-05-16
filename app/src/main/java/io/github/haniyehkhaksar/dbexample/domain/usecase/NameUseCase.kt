package io.github.haniyehkhaksar.dbexample.domain.usecase

import io.github.haniyehkhaksar.dbexample.data.repository.DBRepository
import io.github.haniyehkhaksar.dbexample.domain.domainmodel.Name
import io.github.haniyehkhaksar.dbexample.utils.MyResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NameUseCase @Inject constructor(private val dbRepository: DBRepository) {

    fun execute(): Flow<MyResult<List<Name>>> {
        return dbRepository.getNames()
    }
}