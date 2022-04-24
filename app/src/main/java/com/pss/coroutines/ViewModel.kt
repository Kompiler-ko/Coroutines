package com.pss.coroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {
    val userList = listOf("User1", "User2", "User3", "User4", "User5")

    fun viewModelScope() = viewModelScope.launch {
        flow {
            userList.forEach { user ->
                emit(user)
                delay(1500)
            }
        }.collect{ user ->
            Log.d("TAG", user)
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun viewModelDispatcher() = viewModelScope.launch {
        Log.d("TAG", "parent : ${coroutineContext[CoroutineDispatcher]}")
        launch(Dispatchers.IO) {
            Log.d("TAG", "child : ${coroutineContext[CoroutineDispatcher]}")
        }
    }
}