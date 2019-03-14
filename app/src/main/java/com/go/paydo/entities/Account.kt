package com.go.paydo.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "account")
data class Account(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "id")
    var id:Int,

    @ColumnInfo(name = "owner")
    var owner:String




) {

    /**
     * TODO(1): Create an "Account" entity data class. Done
     * TODO(2): Set a Float value that holds the total debt
     * TODO(3): Somehow, make a relationship with a list of "Operations"
     * TODO(4): Use LiveData to ensure thread-safe operations
     */
}