package com.bedu.s4.activities

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bedu.s4.R
import com.bedu.s4.adapters.GameAdapter
import com.bedu.s4.models.GameModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GameActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var fabAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        listView = findViewById(R.id.listView)
        fabAdd = findViewById(R.id.fabAdd)

        val gameList = getGames()

        val adapter = GameAdapter(this, gameList)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
            val gameName = gameList[position].title
            val category = gameList[position].category
            Toast.makeText(this, "$gameName ganó en la categoría $category", Toast.LENGTH_SHORT).show()
        }
        listView.onItemLongClickListener = AdapterView.OnItemLongClickListener{ parent, view, position, id ->
            Toast.makeText(this, "Seleccionaste el juego ${gameList[position].title}", Toast.LENGTH_SHORT).show()
            true
        }

    }

    private fun getGames(): ArrayList<GameModel> {

        return arrayListOf(
            GameModel("Call of duty", "Audio design", "Mature", 3.5f, R.drawable.call_of_duty),
            GameModel("Control", "Art direction", "Everyone", 4.5f, R.drawable.control),
            GameModel("Destiny 2", "Community support", "Everyone", 3.7f, R.drawable.destiny2),
            GameModel("Devil may cry 5", "Action game", "Teen", 4.2f, R.drawable.devil_may_cry_5),
            GameModel(
                "Sekiro: shadows dies twice",
                "Game of the year",
                "Only Adults",
                3.0f,
                R.drawable.sekiro
            ),
            GameModel(
                "Super smash bros ultimate",
                "Fighting game",
                "Everyone",
                4.9f,
                R.drawable.smash
            )
        )
    }
}