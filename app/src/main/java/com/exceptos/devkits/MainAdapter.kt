package com.exceptos.devkits

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_kit_list_view_holder.view.*

import android.content.Context
import java.util.*


class MainAdapter(val mContext: Context,
                   var mArrayList: ArrayList<String>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return mArrayList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val mView = LayoutInflater.from(mContext).inflate(R.layout.main_kit_list_view_holder, parent, false)
        return ViewHolder(mView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val androidColors = mContext.resources.getIntArray(R.array.random_color)
        val randomAndroidColor = androidColors[Random().nextInt(androidColors.size)]

        holder.leftviewstyle.setBackgroundColor(randomAndroidColor)
        holder.titlename.text = mArrayList[position]
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var titlename = view.title
        var leftviewstyle = view.left_view_style
    }
}