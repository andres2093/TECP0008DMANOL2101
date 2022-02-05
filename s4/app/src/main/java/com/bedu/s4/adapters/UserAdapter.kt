package com.bedu.s4.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bedu.s4.R
import com.bedu.s4.models.UserModel

class UserAdapter(var context: Context, var users: MutableList<UserModel>):
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = users[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    //El ViewHolder ata los datos del RecyclerView a la Vista para desplegar la información
    //También se encarga de gestionar los eventos de la View, como los clickListeners
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nombre = view.findViewById(R.id.tvNombre) as TextView
        val status = view.findViewById(R.id.tvStatus) as TextView
        val phone = view.findViewById(R.id.tvPhone) as TextView
        val image = view.findViewById(R.id.userImage) as ImageView

        //"atando" los datos a las Views
        fun bind(contact: UserModel, context: Context){
            nombre.text = contact.name
            status.text = contact.status
            phone.text = contact.phone
            image.setImageResource(contact.idImage)

            //Gestionando los eventos e interacciones con la vista
            itemView.setOnClickListener{
                Toast.makeText(context, "Llamando a ${contact.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}