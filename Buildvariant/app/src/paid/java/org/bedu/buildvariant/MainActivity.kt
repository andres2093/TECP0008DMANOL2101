package org.bedu.buildvariant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtUsername =findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        val btnLogin =findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            when{
                edtUsername.text.toString() == "" -> Toast.makeText(this, R.string.error_user, Toast.LENGTH_SHORT).show()
                edtPassword.text.toString() == "" -> Toast.makeText(this, R.string.error_pass, Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show()
            }
        }
    }
}