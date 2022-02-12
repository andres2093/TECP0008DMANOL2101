package com.bedu.s5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bedu.s5.databinding.ActivityMainBinding
import com.bedu.s5.e1.activities.E1Activity

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
    }
}