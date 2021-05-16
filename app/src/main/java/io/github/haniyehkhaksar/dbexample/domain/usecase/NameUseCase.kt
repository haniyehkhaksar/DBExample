package io.github.haniyehkhaksar.dbexample.domain.usecase

import io.github.haniyehkhaksar.dbexample.data.repository.DBRepository
import io.github.haniyehkhaksar.dbexample.domain.domainmodel.Name
import io.github.haniyehkhaksar.dbexample.utils.MyResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NameUseCase @Inject constructor(private val dbRepository: DBRepository) {

    sealed class Result {
        data class Success(val data: List<Name>) : Result()
        data class Error(val e: Throwable) : Result()
    }


    suspend fun execute(): Result {
        return try {
            Result.Success(dbRepository.getNames())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}