package com.exceptos.devkits.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.exceptos.devkits.MainActivity
import com.exceptos.devkits.R
import com.exceptos.devkits.fragments.Buttons.Buttons
import com.exceptos.devkits.fragments.Dialogs.Dialogs
import java.util.ArrayList

class DialogActivity : AppCompatActivity() {

    private lateinit var mActivity: Activity
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        mActivity = this@DialogActivity
        viewPager = findViewById(R.id.viewpager)

        setupViewPager(viewPager)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(mActivity, MainActivity::class.java))
        finish()
    }

    private fun setupViewPager(viewPager: ViewPager) {

        val adapter = ViewPagerAdapter(this.supportFragmentManager)

        adapter.addFragment(Dialogs(), "Dialogs")

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
