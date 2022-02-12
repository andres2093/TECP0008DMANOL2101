package com.bedu.s5.e2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bedu.s5.databinding.FragmentDetailBinding
import com.bedu.s5.e2.models.Product

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    fun showProduct(product: Product) {
        binding.detailView.visibility = View.VISIBLE
        binding.tvProduct.text = product.name
        binding.tvDescription.text = product.description
        binding.rbRate.rating = product.rating
        binding.imgProduct.setImageResource(product.idImage)
        binding.tvPrice.text = product.price

    }
}