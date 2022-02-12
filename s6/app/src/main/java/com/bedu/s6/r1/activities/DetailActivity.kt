package com.bedu.s6.r1.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.s6.r1.fragments.DetailFragment
import com.bedu.s6.r1.models.Product
import com.bedu.s6.R

class DetailActivity : AppCompatActivity() {

    companion object {
        const val PRODUCT = "PRODUCT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product = intent.getParcelableExtra<Product>(PRODUCT)
        val detailFragment = supportFragmentManager.findFragmentById(R.id.fragmentDetail) as? DetailFragment
        if (product != null) {
            detailFragment?.showProduct(product)
        }

    }
}