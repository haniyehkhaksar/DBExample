package io.github.haniyehkhaksar.dbexample.domain.usecase

import io.github.haniyehkhaksar.dbexample.data.repository.DBRepository
import javax.inject.Inject

class AddNameUseCase @Inject constructor(private val dbRepository: DBRepository) {

    sealed class Result {
        data class Success(val data: Unit) : Result()
        data class Error(val e: Throwable) : Result()
    }

    suspend fun execute(name:String): Result {
        return try {
            Result.Success(dbRepository.insertName(name))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}