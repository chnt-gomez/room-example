package com.go.paydo.repositories

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import com.go.paydo.daos.OperationsDAO
import com.go.paydo.entities.Operation

class OperationsRepository (private val operationsDao : OperationsDAO) {

    val allOperations : LiveData<List<Operation>> = operationsDao.getAllOperations()

    @WorkerThread
    suspend fun insert (operation : Operation){
        operationsDao.insert(operation)
    }

}