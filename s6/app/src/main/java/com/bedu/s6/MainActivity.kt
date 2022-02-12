package com.bedu.s6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bedu.s6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancel.setOnClickListener {
            Toast.makeText(this, android.R.string.cancel, Toast.LENGTH_LONG).show()
        }
        binding.btnOk.setOnClickListener {
            Toast.makeText(this, android.R.string.ok, Toast.LENGTH_LONG).show()
        }
    }
}