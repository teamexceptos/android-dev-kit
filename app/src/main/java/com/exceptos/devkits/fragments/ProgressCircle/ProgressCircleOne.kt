package com.exceptos.devkits.fragments.ProgressCircle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.exceptos.devkits.R
import com.exceptos.devkits.views.ProgressArc

class ProgressCircleOne : Fragment() {

    lateinit var progressArc: ProgressArc

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.progress_circle_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressArc = view.findViewById(R.id.progress_arc)
        progressArc.run {
            maxInputProgress = 120
            progress = 90
        }
    }
}