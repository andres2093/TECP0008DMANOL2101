package com.bedu.s3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class LoggedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged)

        val txvName = findViewById<TextView>(R.id.txvName)
        val txvEmail = findViewById<TextView>(R.id.txvEmail)
        val txvPhone = findViewById<TextView>(R.id.txvPhone)

        val bundle = intent.extras

        Log.e("TAG", "onCreate: $bundle")

        val name = bundle?.getString(USER_FULL_NAME, "")
        val email = bundle?.getString(USER_EMAIL, "")
        val phone = bundle?.getString(USER_PHONE, "")

        txvName.text = name
        txvEmail.text = email
        txvPhone.text = phone

        Toast.makeText(this, name, Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Log.e("LoggedActivity", "onStart ejecutado")
    }

    override fun onResume() {
        super.onResume()
        Log.e("LoggedActivity", "onResume ejecutado")
    }

    override fun onPause() {
        Log.e("LoggedActivity", "onPause ejecutado")
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        Log.e("LoggedActivity", "onStop ejecutado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("LoggedActivity", "onRestart ejecutado")
    }

    override fun onDestroy() {
        Log.e("LoggedActivity", "onDestroy ejecutado")
        super.onDestroy()
    }
}