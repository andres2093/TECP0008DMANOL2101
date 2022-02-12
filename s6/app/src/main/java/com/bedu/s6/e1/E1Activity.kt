package com.bedu.s6.e1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bedu.s6.R
import com.bedu.s6.databinding.ActivityE1Binding
import com.bedu.s6.databinding.ActivityMainBinding

class E1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityE1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityE1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancel.setOnClickListener {
            Toast.makeText(this, android.R.string.cancel, Toast.LENGTH_LONG).show()
        }
        binding.btnOk.setOnClickListener {
            Toast.makeText(this, android.R.string.ok, Toast.LENGTH_LONG).show()
        }
    }
}