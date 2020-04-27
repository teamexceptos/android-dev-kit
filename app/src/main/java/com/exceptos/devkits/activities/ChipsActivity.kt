package com.exceptos.devkits.activities

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.exceptos.devkits.R
import com.exceptos.devkits.fragments.Chips.Chips
import com.exceptos.devkits.utils.setupViewPager

class ChipsActivity : AppCompatActivity() {

    private lateinit var mActivity: Activity
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        mActivity = this@ChipsActivity
        viewPager = findViewById(R.id.viewpager)

        setupViewPager(mActivity as FragmentActivity, Chips(), viewPager)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
