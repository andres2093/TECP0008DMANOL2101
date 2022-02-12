package com.bedu.s6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bedu.s6.databinding.ActivityMainBinding
import com.bedu.s6.e1.E1Activity
import com.bedu.s6.e2.E2Activity
import com.bedu.s6.e3.E3Activity
import com.bedu.s6.r1.activities.R1Activity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnE1.setOnClickListener {
            val intent = Intent(this, E1Activity::class.java)
            startActivity(intent)
        }
        binding.btnR1.setOnClickListener {
            val intent = Intent(this, R1Activity::class.java)
            startActivity(intent)
        }
        binding.btnE2.setOnClickListener {
            val intent = Intent(this, E2Activity::class.java)
            startActivity(intent)
        }
        binding.btnE3.setOnClickListener {
            val intent = Intent(this, E3Activity::class.java)
            startActivity(intent)
        }
    }
}