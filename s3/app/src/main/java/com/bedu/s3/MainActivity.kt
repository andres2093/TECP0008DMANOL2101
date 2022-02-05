package com.bedu.s3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

//const val USER_NAME = "com.bedu.s3.USER_NAME"
const val USER_FULL_NAME = "USER_FULL_NAME"
const val USER_PHONE = "USER_PHONE"
const val USER_EMAIL = "USER_EMAIL"

class MainActivity : AppCompatActivity() {

    private lateinit var imvStatus: ImageView
    private lateinit var editName: EditText
    private lateinit var editLastName: EditText
    private lateinit var editPhone: EditText
    private lateinit var editEmail: EditText
    private lateinit var btnAccept: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        imvStatus = findViewById(R.id.imvStatus)
        editName = findViewById(R.id.edtName)
        editLastName = findViewById(R.id.edtLastname)
        editPhone = findViewById(R.id.edtPhone)
        editEmail = findViewById(R.id.edtEmail)
        btnAccept = findViewById(R.id.btnAccept)

        btnAccept.setOnClickListener {
            if (editName.text.toString().isNotEmpty() ||
                editLastName.text.toString().isNotEmpty() ||
                editPhone.text.toString().isNotEmpty() ||
                editEmail.text.toString().isNotEmpty()
            ) {

                val bundle = Bundle()
                bundle.putString(USER_FULL_NAME, "${editName.text} ${editLastName.text}")
                bundle.putString(USER_PHONE, editPhone.text.toString())
                bundle.putString(USER_EMAIL, editEmail.text.toString())

                val intent = Intent(this, LoggedActivity::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
//                finish()

//                editName.text.clear()
//                editLastName.text.clear()
//                editPhone.text.clear()
//                editEmail.text.clear()
            } else {
                Toast.makeText(this, "Completa los campos!", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "onStart ejecutado")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "onResume ejecutado")
    }

    override fun onPause() {
        Log.e("MainActivity", "onPause ejecutado")
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity", "onStop ejecutado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity", "onRestart ejecutado")
    }

    override fun onDestroy() {
        Log.e("MainActivity", "onDestroy ejecutado")
        super.onDestroy()
    }
}