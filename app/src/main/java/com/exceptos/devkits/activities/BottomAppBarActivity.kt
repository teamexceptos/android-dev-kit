package com.exceptos.devkits.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.exceptos.devkits.R
import com.exceptos.devkits.utils.BottomNavigationDrawer

class BottomAppBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_appbar)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottom_appbar_menu_primary, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> BottomNavigationDrawer().show(supportFragmentManager, BottomNavigationDrawer().tag)
            R.id.app_bar_search -> toast("Search menu item is clicked!")
            R.id.app_bar_mail -> toast("Fav menu item is clicked!")
            R.id.app_bar_archieve -> toast("Settings item is clicked!")
            R.id.app_bar_delete -> toast("Settings item is clicked!")
        }
        return true
    }
    private fun toast(s: String) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }


}




