package com.exceptos.devkits.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.exceptos.devkits.MainActivity
import com.exceptos.devkits.R
import com.exceptos.devkits.fragments.Buttons.Buttons
import com.exceptos.devkits.fragments.ProgressBar.ProgressBarOne
import java.util.*

class ButtonsActivity : AppCompatActivity() {

    private val mActivity: Activity = this@ButtonsActivity
    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fragments)

        viewPager = findViewById(R.id.viewpager)
        setupViewPager(viewPager!!)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun setupViewPager(viewPager: ViewPager) {

        val adapter = ViewPagerAdapter(this.supportFragmentManager)

        adapter.addFragment(Buttons(), "Buttons")

        viewPager.adapter = adapter
        viewPager.setCurrentItem(0, true)
        viewPager.offscreenPageLimit = adapter.count
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {

            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)

        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }
}