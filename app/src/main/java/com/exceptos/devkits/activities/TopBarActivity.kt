package com.exceptos.devkits.activities

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.exceptos.devkits.R
import com.exceptos.devkits.fragments.Sliders.Sliders
import com.exceptos.devkits.utils.setupViewPager

class TopBarActivity : AppCompatActivity() {

    private val mActivity: Activity = this@TopBarActivity
    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fragments)

        viewPager = findViewById(R.id.viewpager)

        val arrayFragment = ArrayList<Fragment>()

        setupViewPager(mActivity as FragmentActivity, Sliders(), viewPager!!)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}