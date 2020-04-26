package com.exceptos.devkits.fragments.TopBars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.exceptos.devkits.R
import com.exceptos.devkits.views.setupTextView
import kotlinx.android.synthetic.main.top_bar_reg_three.*
import kotlinx.android.synthetic.main.top_bar_reg_two.topAppBarRegularTwo


class TopBarRegularThree : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.top_bar_reg_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topAppBarRegularTwo.setNavigationOnClickListener {
            // Handle navigation icon press
        }

        topAppBarRegularTwo.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.app_bar_more -> {
                    // Handle favorite icon press
                    true
                }
                R.id.app_bar_fav -> {
                    // Handle search icon press
                    true
                }
                else -> false
            }
        }

        for (x in 0..36) {
            regular_llyt_top_bar_three.addView(setupTextView(requireContext(), "Dev kit list items"))
        }

    }
}