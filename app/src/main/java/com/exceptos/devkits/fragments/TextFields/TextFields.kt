package com.exceptos.devkits.fragments.TextFields

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.exceptos.devkits.R
import kotlinx.android.synthetic.main.text_fields.*

class TextFields : Fragment() {

    val list = listOf("Eat", "Code", "Android", "Sleep", "Repeat")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.text_fields, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list_adapter = ArrayAdapter(requireContext(), R.layout.item_list, list)

        filled_autocomplete.setAdapter(list_adapter)
        outlined_autocomplete.setAdapter(list_adapter)

    }
}