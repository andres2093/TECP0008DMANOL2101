package com.bedu.s5.e2.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.s5.R
import com.bedu.s5.e2.fragments.DetailFragment
import com.bedu.s5.e2.models.Product

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