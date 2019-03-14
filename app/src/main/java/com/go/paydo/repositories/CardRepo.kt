package com.go.paydo.repositories

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.go.paydo.daos.CardDAO
import com.go.paydo.database.CardDatabase
import com.go.paydo.entities.Card

class CardRepo(application: Application) {

    private val roomDatabase = CardDatabase.getInstance(application)
    private val cardDao = roomDatabase?.cardDao()

    private var mAllCards : LiveData<List<Card>?>?

    init {
        mAllCards = cardDao?.getAllCards()
    }


    fun getAllCards() : LiveData<List<Card>?>?{
        return mAllCards
    }

    fun insert(card : Card) {
        InsertTask(cardDao).execute(card)
    }

    companion object {
        class InsertTask(private val cardDao : CardDAO?) : AsyncTask<Card, Void?, Void?>(){
            override fun doInBackground(vararg params: Card): Void? {
                cardDao?.insert(params[0])
                return null
            }
        }

    }

}