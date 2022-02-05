package com.bedu.s4.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.bedu.s4.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var fabAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        fabAdd = findViewById(R.id.fabAdd)

        val modeloCoches = arrayOf(
            "Vento",
            "Jetta",
            "Fit",
            "Sonic",
            "206",
            "Tsuru",
            "Versa",
            "Windstar",
            "Safira",
            "Monsa",
            "Lobo",
            "HR-V",
            "Gol",
            "Bora",
            "Rav4",
            "Astra",
            "Mustang",
            "Corsa",
            "Pointer",
            "Aveo",
            "Beetle",
            "Mini cooper"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, modeloCoches)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this, "Seleccionaste el coche ${modeloCoches[position]}", Toast.LENGTH_SHORT).show()
        }
        listView.onItemLongClickListener = AdapterView.OnItemLongClickListener{ parent, view, position, id ->
            Toast.makeText(this, "Seleccionaste el coche ${modeloCoches[position]} Long", Toast.LENGTH_SHORT).show()
            true
        }

    }

}