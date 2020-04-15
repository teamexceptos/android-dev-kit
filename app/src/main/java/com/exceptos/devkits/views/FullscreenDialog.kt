package com.exceptos.devkits.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import com.exceptos.devkits.R


class FullscreenDialog: DialogFragment() {

    private lateinit var dismissButton: ImageButton
    private lateinit var dismissButton2: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fullscreen_dialog, container)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dismissButton = view.findViewById(R.id.fullscreen_dismiss_button_toolbar)
        dismissButton2 = view.findViewById(R.id.fullscreen_dismiss_button)

        dismissButton.setOnClickListener {
            dismiss()
        }

        dismissButton2.setOnClickListener {
            dismiss()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme_FullScreenDialog);
    }

    override fun onStart() {
        super.onStart()

        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window?.setLayout(width, height)

        }
    }
}