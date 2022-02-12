package com.bedu.s5.e3.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bedu.s5.databinding.FragmentBetoBinding

class BetoFragment : Fragment() {

    private lateinit var binding: FragmentBetoBinding

    override fun onAttach(context: Context) {
        Log.d("Beto", "onAttach llamado")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Beto", "onCreate llamado")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBetoBinding.inflate(layoutInflater)

        Log.d("Beto", "onCreateView llamado")
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Beto", "onActivityCreated llamado")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("Beto", "onStart llamado")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Beto", "onResume llamado")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Beto", "onPause llamado")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Beto", "onStop llamado")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Beto", "onDestroyView llamado")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("Beto", "onDestroy llamado")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("Beto", "onDetach llamado")
        super.onDetach()
    }
}