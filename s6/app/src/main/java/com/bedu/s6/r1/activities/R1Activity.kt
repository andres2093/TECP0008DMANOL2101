package com.bedu.s6.r1.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.s6.R
import com.bedu.s6.r1.fragments.DetailFragment
import com.bedu.s6.r1.fragments.ListFragment

class R1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_r1)

        val listFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentList) as ListFragment

        listFragment.setListener {
            val detailFragment =
                supportFragmentManager.findFragmentById(R.id.fragmentDetail) as? DetailFragment

            // Pantalla grande, mostrar detalle en el fragment
            if (detailFragment != null) {
                detailFragment.showProduct(it)
            } else { //pantalla pequeña, navegar a un nuevo Activity
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(DetailActivity.PRODUCT, it)
                startActivity(intent)
            }
        }
    }
}