package com.bedu.s4.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bedu.s4.R
import com.bedu.s4.adapters.UserAdapter
import com.bedu.s4.models.UserModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

const val ADD_NAME = "ADD_NAME"
const val ADD_PHONE = "ADD_PHONE"
const val ADD_STATUS = "ADD_STATUS"
const val ADD_IMAGE = "ADD_IMAGE"
const val ADD_USER_RESULT = 2

class UsersActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var fabAdd: FloatingActionButton

    private lateinit var users: MutableList<UserModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        recyclerView = findViewById(R.id.recyclerView)
        fabAdd = findViewById(R.id.fabAdd)

        setUpRecyclerView()

        fabAdd.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()

            val intent = Intent(this, AddUserActivity::class.java)
            startActivityForResult(intent, ADD_USER_RESULT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_USER_RESULT) {
            if (resultCode == Activity.RESULT_OK) {
                var placeholder = ""
                if (data != null) {
                    val name = data.getStringExtra(ADD_NAME)
                    val phone = data.getStringExtra(ADD_PHONE)
                    val status = data.getStringExtra(ADD_STATUS)
                    val imgProfile = data.getIntExtra(ADD_IMAGE, R.drawable.unknown)

                    users.add(0, UserModel(name!!, status!!, phone!!, imgProfile))
                    adapter.notifyItemChanged(0)
                    placeholder = "Creado correctamente!"
                } else {
                    placeholder = "Error!"
                }
                Snackbar.make(recyclerView, placeholder, Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }

    //configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerView() {
        recyclerView.setHasFixedSize(true)
        //nuestro layout va a ser de una sola columna
        recyclerView.layoutManager = LinearLayoutManager(this)

        users = getContacts()
        //seteando el Adapter
        adapter = UserAdapter(this, users)
        //asignando el Adapter al RecyclerView
        recyclerView.adapter = adapter
    }

    //generamos datos dummy con este método
    private fun getContacts(): MutableList<UserModel> {
        val contacts: MutableList<UserModel> = ArrayList()

        contacts.add(UserModel("Pablo Perez", "disponible", "5535576823", R.drawable.unknown))
        contacts.add(UserModel("Juan Magaña", "on smash", "553552432", R.drawable.unknown))
        contacts.add(UserModel("Leticia Pereda", "disponible", "5553454363", R.drawable.unknown))
        contacts.add(
            UserModel(
                "Manuel Lozano",
                "livin' la vida loca",
                "9613245432",
                R.drawable.unknown
            )
        )
        contacts.add(UserModel("Ricardo Belmonte", "disponible", "6332448739", R.drawable.unknown))
        contacts.add(
            UserModel(
                "Rosalina",
                "lookin' to the stars",
                "7546492750",
                R.drawable.unknown
            )
        )
        contacts.add(UserModel("Thalía Fernandez", "no fear", "5587294655", R.drawable.unknown))
        contacts.add(
            UserModel(
                "Sebastián Cárdenas",
                "no molestar",
                "4475655578",
                R.drawable.unknown
            )
        )

        return contacts
    }
}