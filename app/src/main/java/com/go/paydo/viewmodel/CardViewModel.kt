package com.go.paydo.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.go.paydo.entities.Card
import com.go.paydo.repositories.CardRepo

class CardViewModel(application: Application) : AndroidViewModel(application) {
    private val cardRepo = CardRepo(application)
    var allCards = cardRepo.getAllCards()

    fun insertCard(card : Card){
        cardRepo.insert(card)
    }
}
