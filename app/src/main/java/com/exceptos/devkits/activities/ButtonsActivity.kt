package com.exceptos.devkits.activities

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.exceptos.devkits.R
import com.exceptos.devkits.fragments.Buttons.Buttons
import com.exceptos.devkits.utils.setupViewPager

class ButtonsActivity : AppCompatActivity() {

    private val mActivity: Activity = this@ButtonsActivity
    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fragments)

        viewPager = findViewById(R.id.viewpager)

        setupViewPager(mActivity as FragmentActivity, Buttons(), viewPager!!)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}