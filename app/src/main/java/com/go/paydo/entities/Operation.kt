package com.go.paydo.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull


@Entity(tableName = "operation")
data class Operation(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "operation_id")
    var accountId : Int?,

    @ColumnInfo(name = "reference")
    var reference : String? = "N/A",

    @ColumnInfo(name = "apply_date")
    @NonNull
    var applyDate : Long?,

    @ColumnInfo(name ="partial")
    @NonNull
    var partial : Int? = 1,

    @ColumnInfo(name ="total_payments")
    @NonNull
    var totalPayment : Int? = 1,

    @ColumnInfo(name = "amount")
    @NonNull
    var amount : Float? = 0.0F
    ) {
}