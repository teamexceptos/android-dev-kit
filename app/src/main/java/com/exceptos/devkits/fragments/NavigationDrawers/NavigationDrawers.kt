package com.exceptos.devkits.fragments.NavigationDrawers


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat

import com.exceptos.devkits.R
import kotlinx.android.synthetic.main.navigation_drawers.*

/**
 * A simple [Fragment] subclass.
 */
class NavigationDrawers : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.navigation_drawers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        open_drawer.setOnClickListener {
            drawer_layout.openDrawer(GravityCompat.START)
        }
    }


}
