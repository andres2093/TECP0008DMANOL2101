package com.bedu.s5.e2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedu.s5.R
import com.bedu.s5.databinding.FragmentListBinding
import com.bedu.s5.e2.adapters.RecyclerAdapter
import com.bedu.s5.e2.models.Product

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var mAdapter: RecyclerAdapter
    private var listener: (Product) -> Unit = {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecyclerView()
    }

    fun setListener(l: (Product) -> Unit) {
        listener = l
    }

    //generamos datos dummy con este método
    private fun getProducts(): MutableList<Product> {
        val products: MutableList<Product> = ArrayList()

        products.add(
            Product(
                "Control ps5",
                "Disponible el 20 de noviembre",
                "$1400",
                4.6f,
                R.drawable.control
            )
        )
        products.add(Product("Intel core i9", "10ma Generación", "$9800", 4.4f, R.drawable.corei9))
        products.add(Product("Lector Kobo", "Disponible Prime", "$2235", 3.8f, R.drawable.kobo))
        products.add(
            Product(
                "Audífonos Sony xm3",
                "Noise Cancelling",
                "$6449",
                4.8f,
                R.drawable.xm3
            )
        )

        return products
    }

    //configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerView() {
        binding.recyclerProducts.setHasFixedSize(true)
        binding.recyclerProducts.layoutManager = LinearLayoutManager(activity)
        //seteando el Adapter
        mAdapter = RecyclerAdapter(requireActivity(), getProducts(), listener)
        //asignando el Adapter al RecyclerView
        binding.recyclerProducts.adapter = mAdapter
    }
}