package com.bedu.s2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class SecondActivity : AppCompatActivity() {

    private lateinit var edtMsg: EditText
    private lateinit var edtPhone: EditText
    private lateinit var txvMsg: TextView
    private lateinit var btnAccept: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        edtMsg = findViewById(R.id.edtMsg)
        edtPhone = findViewById(R.id.edtPhone)
        txvMsg = findViewById(R.id.txvMsg)

        edtMsg.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                txvMsg.text = edtMsg.text
            }
        })

        btnAccept = findViewById(R.id.btnAccept)
        btnAccept.setOnClickListener {
            Toast.makeText(this, "Los datos son: ${edtMsg.text} y ${edtPhone.text}", Toast.LENGTH_SHORT).show()
        }

    }
}