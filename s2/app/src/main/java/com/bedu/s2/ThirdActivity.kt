package com.bedu.s2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import coil.load

class ThirdActivity : AppCompatActivity() {

    private lateinit var imvStatus: ImageView
    private lateinit var editName: EditText
    private lateinit var editLastName: EditText
    private lateinit var editPhone: EditText
    private lateinit var editEmail: EditText
    private lateinit var btnAccept: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_third)

        imvStatus = findViewById(R.id.imvStatus)
        editName = findViewById(R.id.edtName)
        editLastName = findViewById(R.id.edtLastname)
        editPhone = findViewById(R.id.edtPhone)
        editEmail = findViewById(R.id.edtEmail)
        btnAccept = findViewById(R.id.btnAccept)

        imvStatus.load("https://raw.githubusercontent.com/beduExpert/Kotlin-Intermedio-2020/master/images/android-kotlin.png")

        btnAccept.setOnClickListener {
            if (
                editName.text.toString().isEmpty() &&
                editLastName.text.toString().isEmpty() &&
                editPhone.text.toString().isEmpty() &&
                editEmail.text.toString().isEmpty()
            ) {
                imvStatus.setImageResource(R.drawable.wrong)
            } else {
                imvStatus.setImageResource(R.drawable.correct)
            }
        }
    }
}