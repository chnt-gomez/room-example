package com.go.paydo.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.go.paydo.entities.Operation

interface OperationsDAO {

    @Query("SELECT * FROM operations")
    fun getAllOperations() : LiveData<List<Operation>>

    @Insert
    fun insert(operation : Operation)

}