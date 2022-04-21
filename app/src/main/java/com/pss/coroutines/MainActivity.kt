package com.pss.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.MainThread
import kotlinx.coroutines.*
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


    }
}