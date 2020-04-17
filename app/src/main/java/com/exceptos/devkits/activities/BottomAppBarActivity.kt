package com.exceptos.devkits.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.exceptos.devkits.R
import com.exceptos.devkits.R.menu.bottom_appbar_menu_primary
import com.exceptos.devkits.R.menu.bottom_appbar_menu_secondary
import com.exceptos.devkits.utils.BottomNavigationDrawer
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_bottom_app_bar.*
import kotlinx.android.synthetic.main.bottom_appbar.*

class BottomAppBarActivity : AppCompatActivity() {

    private var currentFabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)

        screen_label.visibility = GONE


        bottom_app_bar.setNavigationOnClickListener {
            BottomNavigationDrawer().show(supportFragmentManager, BottomNavigationDrawer().tag)
        }

        val addVisibilityChanged: FloatingActionButton.OnVisibilityChangedListener =
            object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    super.onHidden(fab)
                    bottom_app_bar.toggleFabAlignment()
                    bottom_app_bar.replaceMenu(
                        if (currentFabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) bottom_appbar_menu_secondary
                        else bottom_appbar_menu_primary
                    )
                    fab?.setImageDrawable(
                        if (currentFabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) ContextCompat.getDrawable(
                            this@BottomAppBarActivity,
                            R.drawable.ic_reply
                        )
                        else ContextCompat.getDrawable(this@BottomAppBarActivity, R.drawable.ic_add)
                    )
                    fab?.show()
                }
            }
        toggle_fab_alignment_button.setOnClickListener {
            if (screen_label.visibility == GONE) screen_label.visibility = VISIBLE
            fab.hide(addVisibilityChanged)
            invalidateOptionsMenu()
            bottom_app_bar.navigationIcon = if (bottom_app_bar.navigationIcon != null) null
            else ContextCompat.getDrawable(this@BottomAppBarActivity, R.drawable.ic_menu)
            when (screen_label.text) {
                getString(R.string.primary_screen_text) -> screen_label.text =
                    getString(R.string.secondary_sceen_text)
                getString(R.string.secondary_sceen_text) -> screen_label.text =
                    getString(R.string.primary_screen_text)
            }
        }

        fab.setOnClickListener {
            toast("fab clicked")
        }

    }

    private fun BottomAppBar.toggleFabAlignment() {
        currentFabAlignmentMode = fabAlignmentMode
        fabAlignmentMode = currentFabAlignmentMode.xor(1)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(bottom_appbar_menu_primary, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> BottomNavigationDrawer().show(supportFragmentManager, BottomNavigationDrawer().tag)
            R.id.app_bar_search -> toast("Search menu item is clicked!")
//            R.id.app_bar_mail -> toast("Fav menu item is clicked!")
//            R.id.app_bar_archieve -> toast("Settings item is clicked!")
//            R.id.app_bar_delete -> toast("Settings item is clicked!")
        }
        return true

    }
    private fun toast(s: String) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }


}




