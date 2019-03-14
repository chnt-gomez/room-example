package com.go.paydo.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

@Entity(tableName = "operations_in_card",
    primaryKeys = ["operationId", " cardId"],
    foreignKeys = [
        ForeignKey(entity = Operation::class, parentColumns = ["id"], childColumns = ["operationId"]),
        ForeignKey(entity = Class::class, parentColumns = ["id"], childColumns = ["cardId"])
    ])
data class OperationsInCard (
    var operationId : Int,
    var cardId : Int
)