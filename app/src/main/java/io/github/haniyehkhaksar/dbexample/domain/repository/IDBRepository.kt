package io.github.haniyehkhaksar.dbexample.domain.repository

import io.github.haniyehkhaksar.dbexample.domain.domainmodel.Name

interface IDBRepository {

    suspend fun getNames(): List<Name>

    suspend fun insertName(name: String)
}