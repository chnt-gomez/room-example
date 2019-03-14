package com.go.paydo.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class OperationsViewModel(application : Application) : AndroidViewModel(application) {

    private var parentJob = Job()

    private val coroutineContext : CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)


    //TODO(9): Make a variable to hold the OperationsRepository

    //TODO(10): Use a cache to hold a result query (Instead of calling the query over and over)

    //TODO(11): Use the 'init' block to initialize the previous step

    //TODO(12 - Optional): Use a Job and a CoroutineContext to enhance lifecycle and prevent memory leaks

    //TODO(13): Create at least 1 insert operation

}