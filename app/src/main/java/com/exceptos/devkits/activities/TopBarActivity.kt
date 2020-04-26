package com.exceptos.devkits.activities

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.exceptos.devkits.R
import com.exceptos.devkits.fragments.TopBars.TopBarRegularFour
import com.exceptos.devkits.fragments.TopBars.TopBarRegularOne
import com.exceptos.devkits.fragments.TopBars.TopBarRegularThree
import com.exceptos.devkits.fragments.TopBars.TopBarRegularTwo
import com.exceptos.devkits.utils.setupViewPager

class TopBarActivity : AppCompatActivity() {

    private val mActivity: Activity = this@TopBarActivity
    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)

        setContentView(R.layout.activity_fragments)

        viewPager = findViewById(R.id.viewpager)

        val arrayFragment = ArrayList<Fragment>()

        arrayFragment.add(TopBarRegularOne())
        arrayFragment.add(TopBarRegularTwo())
        arrayFragment.add(TopBarRegularThree())
        arrayFragment.add(TopBarRegularFour())

        setupViewPager(mActivity as FragmentActivity, arrayFragment, viewPager!!)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}