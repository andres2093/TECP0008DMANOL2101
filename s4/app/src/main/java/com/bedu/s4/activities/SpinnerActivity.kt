package com.bedu.s4.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import com.bedu.s4.R

class SpinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        val spinner =  findViewById<Spinner>(R.id.spinner)

        val language = arrayOf("Selecciona uno", "Inglés", "Español", "Chino", "Ruso", "Coreano", "Alemán", "Francés", "Holandés")

        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, language)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position == 0) {
                    showDialog("No seleccionaste idioma","Vuelve a desplegar la lista y asegúrate de elegir correctamente a alguna")
                } else {
                    showDialog("Seleccionaste idioma", language[position])
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                showDialog("No seleccionaste idioma","Vuelve a desplegar la lista y asegúrate de elegir correctamente a alguna")
            }
        }

        spinner.adapter = adapter
    }

    private fun showDialog(title:String,message:String){
        val builder = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Aceptar"){_, _->  }
            .setNegativeButton("Cancelar"){_, _->  }
            .setNeutralButton("X"){_, _->  }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}