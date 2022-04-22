package com.pss.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import java.lang.IllegalArgumentException
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    @OptIn(InternalCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*  CoroutineScope(Dispatchers.IO).launch {
              //code
          }*/

        /*      val job = Job()
              CoroutineScope(Dispatchers.IO + job).launch {
                  //code1
              }
              CoroutineScope(Dispatchers.IO + job).launch {
                  //code2
              }*/


      /*   val job = CoroutineScope(Dispatchers.Main).launch {
             launch(Dispatchers.IO) {
                 for (n in 0..100000){
                     Log.d("TAG","Child scope1 $n")
                 }
             }
             launch(Dispatchers.IO) {
                 for (n in 0..100000){
                     Log.d("TAG","Child scope2 $n")
                 }
             }
         }
         job.cancel()*/

/*
        lifecycleScope.launch(Dispatchers.IO) {
            for (n in 0..99999){
                Log.d("TAG","$n")
            }
        }

        val userList = listOf("User1", "User2", "User3", "User4", "User5")
        lifecycleScope.launch(Dispatchers.IO) {
            flow {
                userList.forEach { user ->
                    emit(user)
                    delay(1500)
                }
            }.collect{ user ->
                Log.d("TAG", user)
            }
        }
*/


        lifecycleScope.launch {
            Log.d("TAG", "parent : ${Thread.currentThread().name}")
            launch(Dispatchers.IO){
                Log.d("TAG", "child : ${Thread.currentThread().name}")
            }
        }


    /*    CoroutineScope(Dispatchers.Main).launch {
        }
        val job = CoroutineScope(Dispatchers.IO).launch(start = CoroutineStart.LAZY) {
            delay(1000)
            Log.d("TAG", "코루틴")
        }
        job.start()
        job.cancel("job Cancelled", InterruptedException("Cancelled Forcibly"))
        Log.d("TAG", "job state : ${job.isCancelled}")
        job.invokeOnCompletion {
            Log.d("TAG", "throwable : $it")
        }
        Log.d("TAG", "job state : ${job.isCompleted}")
        Log.d("TAG", job.getCancellationException().toString())
    */



 /*       CoroutineScope(Dispatchers.Main).launch {
            val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                Log.d("TAG","exceptionHandler : $throwable")
                when(throwable){
                    is IllegalArgumentException -> { }
                    is InterruptedException -> { }
                }
            }
            val job = CoroutineScope(Dispatchers.IO).launch(
                start = CoroutineStart.LAZY,
                context = exceptionHandler
            ) {
                delay(1000)
                Log.d("TAG","코루틴")
                delay(4000)
                throw InterruptedException()
            }
            job.start()
        }*/
    }
}