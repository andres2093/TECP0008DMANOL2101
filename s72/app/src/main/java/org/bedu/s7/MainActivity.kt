package org.bedu.s7

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var actionMode: ActionMode? = null

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
        findViewById<Button>(R.id.button).setOnLongClickListener {
            if (actionMode == null) actionMode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                startActionMode(ActionModeCallback(), ActionMode.TYPE_FLOATING)
            } else {
                startActionMode(ActionModeCallback())
            }
            true
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
                if (item.isChecked) {
                    Toast.makeText(this, "True", Toast.LENGTH_SHORT).show()
                    item.isChecked = false
                } else {
                    Toast.makeText(this, "False", Toast.LENGTH_SHORT).show()
                    item.isChecked = true
                }
                return true
            }
            R.id.search -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
                item.isChecked = !item.isChecked
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

    inner class ActionModeCallback : ActionMode.Callback {

        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            val inflater = mode?.menuInflater
            inflater?.inflate(R.menu.action_menu, menu)
            mode?.title = "Action menu"
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            menu?.findItem(R.id.cast)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
            return true
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            when (item?.itemId){
                R.id.add -> {
                    actionMode?.title = item.title
                    Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
                    actionMode?.finish()
                    return true
                }
                R.id.cast -> {
                    actionMode?.title = item.title
                    Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
                    actionMode?.finish()
                    return true
                }
            }
            return false
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null
        }
    }
}