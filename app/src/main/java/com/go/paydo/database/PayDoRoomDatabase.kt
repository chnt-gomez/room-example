package com.go.paydo.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.go.paydo.daos.OperationsDAO
import com.go.paydo.entities.Operation

@Database(entities = arrayOf(Operation::class), version = 1)
public abstract class PayDoRoomDatabase : RoomDatabase() {

    abstract fun operationsDao(): OperationsDAO

    companion object {
        @Volatile private var INSTANCE : PayDoRoomDatabase? = null

        fun getInstance(context : Context) : PayDoRoomDatabase{
            val oldInstance = INSTANCE
            if (oldInstance != null){
                return oldInstance
            }else{
                synchronized(this) {
                    val newInstance = Room.databaseBuilder(
                        context.applicationContext,
                        PayDoRoomDatabase::class.java,
                        "paydo"
                    ).build()
                    INSTANCE = newInstance
                    return newInstance
                }
            }
        }
    }
}