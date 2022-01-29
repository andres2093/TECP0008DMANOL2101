package com.bedu.s2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btnAccept: Button
    private lateinit var txvMsg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btnAccept = findViewById(R.id.btnAccept)
        txvMsg = findViewById(R.id.txvMsg)

        btnAccept.setOnClickListener {
            txvMsg.text = getString(R.string.btn_clicked)
            btnAccept.isEnabled = false
            txvMsg.visibility = View.INVISIBLE
        }
    }
}