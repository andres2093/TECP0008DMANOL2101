package com.bedu.s4.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.bedu.s4.R

class AddUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val editName = findViewById<TextView>(R.id.editName)
        val editPhone = findViewById<TextView>(R.id.editPhone)

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        buttonAdd.setOnClickListener {

            val name = editName.text.toString()
            val phone = editPhone.text.toString()
            val status = "disponible"
            val imgProfile = R.drawable.unknown

            val returnIntent = Intent()
            returnIntent.putExtra(ADD_NAME, name)
            returnIntent.putExtra(ADD_STATUS, status)
            returnIntent.putExtra(ADD_PHONE, phone)
            returnIntent.putExtra(ADD_IMAGE, imgProfile)

            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}