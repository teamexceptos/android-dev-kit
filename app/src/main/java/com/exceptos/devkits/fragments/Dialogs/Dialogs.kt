package com.exceptos.devkits.fragments.Dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.exceptos.devkits.R
import com.exceptos.devkits.views.FullscreenDialog
import com.exceptos.devkits.views.ModalBottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class Dialogs : Fragment(), View.OnClickListener {

    override fun onClick(p0: View?) {
        p0?.let {
            when(it){
                simpleDialogButton -> {
                    showSimpleDialog()
                }

                alertDialogButton -> {
                    showAlertDialog()
                }

                confirmDialogButton -> {
                    showConfirmationDialog()
                }

                fullScreenDialogButton -> {
                    showFullscreenDialog()
                }

                modalDialogButton -> {
                    showBottomSheetDialog()
                }

                multichoiceDialogButton -> {
                    showMultiChoiceConfirmationDialog()
                }

            }
        }
    }

    private lateinit var simpleDialogButton: Button
    private lateinit var alertDialogButton: Button
    private lateinit var confirmDialogButton: Button
    private lateinit var fullScreenDialogButton: Button
    private lateinit var modalDialogButton: Button
    private lateinit var multichoiceDialogButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dialogs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        simpleDialogButton = view.findViewById(R.id.simple_dialog_button)
        alertDialogButton = view.findViewById(R.id.alert_dialog_button)
        confirmDialogButton = view.findViewById(R.id.confirm_dialog_button)
        fullScreenDialogButton = view.findViewById(R.id.fullscreen_dialog_button)
        modalDialogButton = view.findViewById(R.id.modal_dialog_button)
        multichoiceDialogButton = view.findViewById(R.id.multi_confirm_dialog_button)

        simpleDialogButton.setOnClickListener(this)
        alertDialogButton.setOnClickListener(this)
        confirmDialogButton.setOnClickListener(this)
        fullScreenDialogButton.setOnClickListener(this)
        modalDialogButton.setOnClickListener(this)

        multichoiceDialogButton.setOnClickListener(this)
    }

    private fun showSimpleDialog(){
        val items = arrayOf("Item 1", "Item 2", "Item 3")
        MaterialAlertDialogBuilder(context!!)
            .setTitle("Simple Dialog")
            .setItems(items) { dialog, which ->
                Toast.makeText(activity!!, "You chose ${items[which]} from the simple dialog!", Toast.LENGTH_LONG).show()
                dialog.dismiss()

            }
            .show()
    }

    private fun showAlertDialog(){
        MaterialAlertDialogBuilder(context!!)
            .setTitle("Alert Dialog")
            .setMessage("The subtitle of this dialog")
            .setNeutralButton("Cancel") { dialog, _ ->
                dialog.dismiss()
                Toast.makeText(activity!!, "You cancelled the alert dialog", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Nah!") { dialog, _ ->
                dialog.dismiss()
                Toast.makeText(activity!!, "You chose Nah! :(", Toast.LENGTH_LONG).show()
            }
            .setPositiveButton("Yea!") { dialog, _ ->
                dialog.dismiss()
                Toast.makeText(activity!!, "You chose Yea! Yay!", Toast.LENGTH_LONG).show()
            }
            .show()
    }

    private fun showConfirmationDialog(){
        val singleItems = arrayOf("Item 1", "Item 2", "Item 3")
        val checkedItem = 1
        //​
        MaterialAlertDialogBuilder(context!!)
            .setTitle("Confirmation Dialog")
            .setNeutralButton("Cancel") { dialog, _ ->
                // Respond to neutral button press
                dialog.dismiss()
                Toast.makeText(activity!!, "You've cancelled the confirmation dialog", Toast.LENGTH_LONG).show()
            }
            .setPositiveButton("Okay") { dialog, _ ->
                // Respond to positive button press
                dialog.dismiss()
                Toast.makeText(activity!!, "You've made your choice", Toast.LENGTH_LONG).show()
            }
            // Single-choice items (initialized with checked item)
            .setSingleChoiceItems(singleItems, checkedItem) { _, which ->
                // Respond to item chosen
                Toast.makeText(activity!!, "You chose ${singleItems[which]}", Toast.LENGTH_LONG).show()
            }
            .show()
    }

    private fun showMultiChoiceConfirmationDialog(){
        val multiItems = arrayOf("Item 1", "Item 2", "Item 3")
        val checkedItems = booleanArrayOf(true, false, false, false)
        //​
        MaterialAlertDialogBuilder(context!!)
            .setNeutralButton("Cancel"){dialog , _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Okay"){ dialog, _ ->
                dialog.dismiss()
            }
            //Multi-choice items (initialized with checked items)
            .setMultiChoiceItems(multiItems, checkedItems) { _, _, _ ->
                // Respond to item chosen
            }
            .show()
    }

    private fun showBottomSheetDialog(){
        if (activity != null){
            val bottomSheetDialog = ModalBottomSheetDialog()
            bottomSheetDialog.show(activity!!.supportFragmentManager, ModalBottomSheetDialog::class.java.simpleName)
        }

    }

    private fun showFullscreenDialog(){
        if (activity != null){
            val fullscreenDialog = FullscreenDialog()
            fullscreenDialog.show(activity!!.supportFragmentManager, FullscreenDialog::class.java.simpleName)
        }

    }


}



