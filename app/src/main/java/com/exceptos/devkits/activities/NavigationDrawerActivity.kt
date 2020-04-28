package com.exceptos.devkits.activities

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.exceptos.devkits.R
import com.exceptos.devkits.fragments.NavigationDrawers.NavigationDrawers
import com.exceptos.devkits.utils.setupViewPager

class NavigationDrawerActivity : AppCompatActivity() {

    private lateinit var mActivity: Activity
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        mActivity = this@NavigationDrawerActivity
        viewPager = findViewById(R.id.viewpager)

        setupViewPager(mActivity as FragmentActivity, NavigationDrawers(), viewPager)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}