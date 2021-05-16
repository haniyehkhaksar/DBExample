package io.github.haniyehkhaksar.dbexample.data.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.haniyehkhaksar.dbexample.domain.domainmodel.Name

@Entity(tableName = "names")
data class NameEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String
)

internal fun NameEntity.toDomainModel() =
    Name(this.id,
        this.name
    )