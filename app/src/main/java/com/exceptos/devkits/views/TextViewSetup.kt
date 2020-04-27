package com.exceptos.devkits.views

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.google.android.material.textview.MaterialTextView

@RequiresApi(Build.VERSION_CODES.M)
fun setupTextView(context: Context, text: String): MaterialTextView {

    val textView = MaterialTextView(context)
    textView.text = text
    textView.width = ViewGroup.LayoutParams.WRAP_CONTENT
    textView.textSize = 19f
    textView.setTextColor(context.getColor(android.R.color.darker_gray))
    textView.gravity = Gravity.LEFT
    textView.setPadding(7, 17, 0, 17)

    return textView
}