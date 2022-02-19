package org.bedu.s7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(findViewById<TextView>(R.id.textView))
        findViewById<Button>(R.id.button).setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.menuInflater.inflate(R.menu.context_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.copy -> {
                            Toast.makeText(this, "Copy", Toast.LENGTH_SHORT).show()
                            true
                        }
                        R.id.paste -> {
                            Toast.makeText(this, "Paste", Toast.LENGTH_SHORT).show()
                            true
                        }
                        R.id.cut -> {
                            Toast.makeText(this, "Cut", Toast.LENGTH_SHORT).show()
                            true
                        }
                    }
                false
            }
            popupMenu.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.help -> {
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.search -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.sub_menu -> {
                Toast.makeText(this, "Sub menu", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        return super.onContextItemSelected(item)
//    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }
}