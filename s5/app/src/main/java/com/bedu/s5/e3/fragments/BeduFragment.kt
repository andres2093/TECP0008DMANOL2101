package com.bedu.s5.e3.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bedu.s5.databinding.FragmentBeduBinding

class BeduFragment : Fragment() {

    private lateinit var binding: FragmentBeduBinding

    override fun onAttach(context: Context) {
        Log.d("Bedu", "onAttach llamado")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Bedu", "onCreate llamado")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBeduBinding.inflate(layoutInflater)

        Log.d("Bedu", "onCreateView llamado")
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Bedu", "onActivityCreated llamado")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("Bedu", "onStart llamado")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Bedu", "onResume llamado")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Bedu", "onPause llamado")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Bedu", "onStop llamado")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Bedu", "onDestroyView llamado")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("Bedu", "onDestroy llamado")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("Bedu", "onDetach llamado")
        super.onDetach()
    }
}