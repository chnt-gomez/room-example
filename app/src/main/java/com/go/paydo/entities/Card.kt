package com.go.paydo.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "cards")
data class Card (
    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id")
    var id:Int?,

    @ColumnInfo(name="card_name")
    var cardName:String?,

    @ColumnInfo(name="cut_day")
    @NonNull
    var cutDay: Int = 1,

    @ColumnInfo(name="due_day")
    @NonNull
    var dueDate: Int = 15
){
    constructor () : this(null, "", 1, 15)
}