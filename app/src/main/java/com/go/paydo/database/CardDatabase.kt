package com.go.paydo.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.go.paydo.daos.CardDAO
import com.go.paydo.entities.Card

@Database(entities = [Card::class], version = 1)
abstract class CardDatabase : RoomDatabase() {

    abstract fun cardDao() : CardDAO

    companion object {
        private var INSTANCE :CardDatabase? = null
        fun getInstance(context : Context) : CardDatabase?{
            synchronized(CardDatabase::class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, CardDatabase::class.java, "myDB").build();
                }
            }
            return INSTANCE
        }

        fun destroy(){
            INSTANCE = null
        }

    }



}