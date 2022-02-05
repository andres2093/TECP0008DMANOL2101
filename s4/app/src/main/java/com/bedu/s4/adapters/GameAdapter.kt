package com.bedu.s4.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bedu.s4.R
import com.bedu.s4.models.GameModel

class GameAdapter(private val context: Context, private val datos: ArrayList<GameModel>) :
    BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(position: Int): Any {
        return datos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.item_game, parent, false)

        val tvTitulo = rowView.findViewById<View>(R.id.tvTitulo) as TextView
        val tvCategoria = rowView.findViewById<View>(R.id.tvCategoria) as TextView
        val tvClasificacion = rowView.findViewById<View>(R.id.tvClasificacion) as TextView
        val rbCalificacion = rowView.findViewById<View>(R.id.rbCalificacion) as RatingBar
        val imgPortada = rowView.findViewById<View>(R.id.imgPortada) as ImageView

        val game = getItem(position) as GameModel

        tvTitulo.text = game.title
        tvCategoria.text = game.category
        tvClasificacion.text = game.ESRB
        rbCalificacion.rating = game.rating
        imgPortada.setImageResource(game.idPortrait)

        return rowView
    }
}