package com.go.paydo.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.go.paydo.entities.Card

@Dao
interface CardDAO {

    @Insert
    fun insert(card : Card)

    @Query("SELECT * from cards")
    fun getAllCards() : LiveData<List<Card>?>

}