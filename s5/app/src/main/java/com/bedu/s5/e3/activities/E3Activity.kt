package com.bedu.s5.e3.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bedu.s5.R
import com.bedu.s5.databinding.ActivityE3Binding
import com.bedu.s5.e3.fragments.BeduFragment
import com.bedu.s5.e3.fragments.BetoFragment

class E3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityE3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityE3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = supportFragmentManager

        //Agregaremos un nuevo Fragment
        binding.addButton.setOnClickListener {
            val fragment = BeduFragment()
            val transaction = manager.beginTransaction()
            transaction.add(R.id.container, fragment, "fragBedu")
            transaction.commit()
//            binding.imageView.setImageResource(R.drawable.bedu)
        }

        binding.removeButton.setOnClickListener {

            val fragmentTag = manager.findFragmentByTag("fragBedu")

            if (fragmentTag != null) {
                val fragment = fragmentTag as BeduFragment
                val transaction = manager.beginTransaction()
                transaction.remove(fragment)
                transaction.commit()
//                supportFragmentManager.beginTransaction().remove(fragment).commit()
            } else {
                Toast.makeText(this, "No hay ningún FragmentBedu agregado", Toast.LENGTH_SHORT)
                    .show()
            }
        }


        binding.hideButton.setOnClickListener {
            val fragmentTag = manager.findFragmentByTag("fragBedu")

            if (fragmentTag != null) {
                val fragment = fragmentTag as BeduFragment
                val transaction = manager.beginTransaction()
                transaction.hide(fragment)
                transaction.commit()
            } else {
                Toast.makeText(this, "No hay ningún FragmentBedu agregado", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.showButton.setOnClickListener {
            val fragmentTag = manager.findFragmentByTag("fragBedu")

            if (fragmentTag != null) {
                val fragment = fragmentTag as BeduFragment
                val transaction = manager.beginTransaction()
                transaction.show(fragment)
                transaction.commit()
            } else {
                Toast.makeText(this, "No hay ningún FragmentBedu agregado", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.detachButton.setOnClickListener {
            val fragmentTag = manager.findFragmentByTag("fragBedu")

            if (fragmentTag != null) {
                val fragment = fragmentTag as BeduFragment
                val transaction = manager.beginTransaction()
                transaction.detach(fragment)
                transaction.commit()
            } else {
                Toast.makeText(this, "No hay ningún FragmentBedu agregado", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.attachButton.setOnClickListener {
            val fragmentTag = manager.findFragmentByTag("fragBedu")

            if (fragmentTag != null) {
                val fragment = fragmentTag as BeduFragment
                val transaction = manager.beginTransaction()
                transaction.attach(fragment)
                transaction.commit()
            } else {
                Toast.makeText(this, "No hay ningún FragmentBedu agregado", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.add2Button.setOnClickListener {
            val fragment = BetoFragment()
            val transaction = manager.beginTransaction()
            transaction.add(R.id.container, fragment, "fragBeto")
            transaction.commit()
        }

        binding.remove2Button.setOnClickListener {
            val fragmentTag = manager.findFragmentByTag("fragBeto")

            if (fragmentTag != null) {
                val fragment = fragmentTag as BetoFragment
                val transaction = manager.beginTransaction()
                transaction.remove(fragment)
                transaction.commit()
            } else {
                Toast.makeText(this, "No hay ningún FragmentBeto agregado", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.replace1Button.setOnClickListener {
            val beduFragment = BeduFragment()
            val transaction = manager.beginTransaction()
            transaction
                .replace(R.id.container, beduFragment, "fragBedu")
                .commit()
        }

        binding.replace2Button.setOnClickListener {
            val betoFragment = BetoFragment()
            val transaction = manager.beginTransaction()
            transaction
                .replace(R.id.container, betoFragment, "fragBeto")
                .commit()
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, BetoFragment(), "fragBeto").commit()
        }
    }
}