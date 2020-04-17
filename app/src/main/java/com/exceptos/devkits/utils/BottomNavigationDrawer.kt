package com.exceptos.devkits.utils

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import com.exceptos.devkits.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.internal.NavigationMenuView
import com.google.android.material.navigation.NavigationView

class BottomNavigationDrawer : BottomSheetDialogFragment() {
    private lateinit var closeButton: ImageView
    private lateinit var navigationView: NavigationView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_navigation_drawer, container, false)
        navigationView = view.findViewById(R.id.navigation_view)
        closeButton = view.findViewById(R.id.close_imageview)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Bottom Navigation Drawer menu item clicks
            when (menuItem.itemId) {
                R.id.nav1 -> toast(context!!, getString(R.string.nav_item1))
                R.id.nav2 -> toast(context!!, getString(R.string.nav_item2))
                R.id.nav3 -> toast(context!!, getString(R.string.nav_item3))
                R.id.nav4 -> toast(context!!, getString(R.string.nav_item4))
                R.id.nav5 -> toast(context!!, getString(R.string.nav_item5))
                R.id.nav6 -> toast(context!!, getString(R.string.nav_item6))
                R.id.nav7 -> toast(context!!, getString(R.string.nav_item7))
                R.id.nav8 -> toast(context!!, getString(R.string.nav_item8))
                R.id.nav9 -> toast(context!!, getString(R.string.nav_item9))
                R.id.nav10 -> toast(context!!, getString(R.string.nav_item10))
                R.id.nav11 -> toast(context!!, getString(R.string.nav_item11))
                R.id.nav12 -> toast(context!!, getString(R.string.nav_item12))
                R.id.nav13 -> toast(context!!, getString(R.string.nav_item13))

            }
            false
        }
        closeButton.setOnClickListener {

            this.dismiss()
        }

        disableNavigationViewScrollbars(navigationView)

        return view


    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.setOnShowListener { e ->
            val d = e as BottomSheetDialog

            val bottomSheet = d.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet!!)
            bottomSheetBehavior.addBottomSheetCallback(object :
                BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    if (slideOffset > 0.5) {
                        closeButton.visibility = View.VISIBLE
                    } else {
                        closeButton.visibility = View.GONE
                    }
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    when (newState) {
                        BottomSheetBehavior.STATE_HIDDEN -> dismiss()
                        // else -> closeButton.visibility = View.GONE
                    }
                }
            })
        }

        return dialog
    }


    private fun disableNavigationViewScrollbars(navigationView: NavigationView?) {
        val navigationMenuView = navigationView?.getChildAt(0) as NavigationMenuView
        navigationMenuView.isVerticalScrollBarEnabled = false
    }

    private fun toast(context: Context, string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }
}


