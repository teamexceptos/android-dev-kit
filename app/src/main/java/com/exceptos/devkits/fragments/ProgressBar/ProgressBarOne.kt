package com.exceptos.devkits.fragments.ProgressBar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.exceptos.devkits.R
import com.exceptos.devkits.views.CustomProgressBar


class ProgressBarOne : Fragment() {

    lateinit var progressBar: CustomProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.progress_bar_custom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progress_horizontal)
        progressBar.setMaxValue(350)
        progressBar.progressBarValue = 70
        progressBar.setText = false

    }
}