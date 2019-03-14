package com.go.paydo.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.go.paydo.database.PayDoRoomDatabase
import com.go.paydo.entities.Operation
import com.go.paydo.repositories.OperationsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class OperationsViewModel(application : Application) : AndroidViewModel(application) {

    private var parentJob = Job()

    private val coroutineContext : CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)
    private val repository : OperationsRepository
    val allOperations: LiveData<List<Operation>>

    init {
        val operationsDao = PayDoRoomDatabase.getInstance(application).operationsDao()
        repository = OperationsRepository(operationsDao)
        allOperations = repository.allOperations
    }

    fun insert(operation : Operation) {
        scope.launch(Dispatchers.IO){
            repository.insert(operation);
        }
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

}