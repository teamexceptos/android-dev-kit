package com.exceptos.devkits.utils

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.exceptos.devkits.fragments.Buttons.Buttons
import java.util.ArrayList

fun setupViewPager(activity: FragmentActivity, fragment: Fragment, viewPager: ViewPager) {

    val adapter = ViewPagerAdapter(activity.supportFragmentManager,
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    )

    adapter.addFragment(fragment, activity.localClassName)

    viewPager.adapter = adapter
    viewPager.setCurrentItem(0, true)
    viewPager.offscreenPageLimit = adapter.count
}

fun setupViewPager(activity: FragmentActivity, arrayFragment: ArrayList<Fragment>, viewPager: ViewPager) {

    val adapter = ViewPagerAdapter(activity.supportFragmentManager,
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    )

    arrayFragment.forEach {
        adapter.addFragment(it, activity.localClassName)
    }

    viewPager.adapter = adapter
    viewPager.setCurrentItem(0, true)
    viewPager.offscreenPageLimit = adapter.count
}

class ViewPagerAdapter(fm: FragmentManager,
                              behavior: Int) : androidx.fragment.app.FragmentStatePagerAdapter(fm, behavior) {

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