package com.bedu.s3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("activities","onCreate ejecutado")
    }

    override fun onStart() {
        super.onStart()
        Log.e("activities","onStart ejecutado")
    }

    override fun onResume() {
        super.onResume()
        Log.e("activities","onResume ejecutado")
    }

    override fun onPause() {
        Log.e("activities","onPause ejecutado")
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        Log.e("activities","onStop ejecutado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("activities","onRestart ejecutado")
    }

    override fun onDestroy() {
        Log.e("activities","onDestroy ejecutado")
        super.onDestroy()
    }
}