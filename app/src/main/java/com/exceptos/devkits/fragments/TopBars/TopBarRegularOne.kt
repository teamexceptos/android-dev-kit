package com.exceptos.devkits.fragments.TopBars

import android.os.Bundle
import android.view.*
import androidx.appcompat.view.ActionMode
import androidx.fragment.app.Fragment
import com.exceptos.devkits.R
import com.exceptos.devkits.activities.TopBarActivity
import kotlinx.android.synthetic.main.top_bar_reg_one.*


class TopBarRegularOne : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.top_bar_reg_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val callback = object : ActionMode.Callback {

            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                requireActivity().menuInflater.inflate(R.menu.contextual_top_bar_menu, menu)
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return false
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                return when (item?.itemId) {
                    R.id.share -> {
                        // Handle share icon press
                        true
                    }
                    R.id.delete -> {
                        // Handle delete icon press
                        true
                    }
                    R.id.more -> {
                        // Handle more item (inside overflow menu) press
                        true
                    }
                    else -> false
                }
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                topAppBarRegularOne.visibility = View.VISIBLE
                top_bar_details.text = "Regular top bar with no behavior"
            }
        }

        top_bar_toggle_action.setOnClickListener {

            val actionMode = (activity as TopBarActivity?)!!.startSupportActionMode(callback)
            topAppBarRegularOne.visibility = View.GONE
            actionMode!!.title = "Contextual top bar"

            top_bar_details.text = "Contextual top bar for action"
        }

        topAppBarRegularOne.setNavigationOnClickListener {
            // Handle navigation icon press
        }

        topAppBarRegularOne.setOnMenuItemClickListener { menuItem ->
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

//        for (x in 0..36) {
//            regular_llyt_top_bar_one.addView(setupTextView(requireContext(), "Dev kit list items"))
//        }

    }
}