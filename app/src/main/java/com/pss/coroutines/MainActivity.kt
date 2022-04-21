package com.pss.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.MainThread
import kotlinx.coroutines.*
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


        /* val job = CoroutineScope(Dispatchers.Main).launch {
             launch {
                 for (n in 0..100000){
                     Log.d("TAG","Child scope1 $n")
                 }
             }
             launch {
                 for (n in 0..100000){
                     Log.d("TAG","Child scope2 $n")
                 }
             }
             for (n in 0..100000){
                 Log.d("TAG","parent scope $n")
             }
         }
         job.cancel()*/

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



        CoroutineScope(Dispatchers.Main).launch {
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
        }
    }
}