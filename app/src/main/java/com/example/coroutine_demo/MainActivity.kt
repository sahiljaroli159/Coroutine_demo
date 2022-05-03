package com.example.coroutine_demo

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val networkCallAns=networkCall()
            Log.d(TAG,networkCallAns)
            Log.d(TAG,"Hello from thread ${Thread.currentThread().name}")
            withContext(Dispatchers.Main){

            }
        }
        Log.d(TAG,"Hello from thread ${Thread.currentThread().name}")

    }
    suspend fun networkCall():String{
        delay(3000L)
        return "This is Network call 1"
    }
}