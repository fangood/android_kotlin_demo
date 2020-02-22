package com.fch.android_demo.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.fch.android_demo.R

class CustomAdapter(private val dataSet:Array<String>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView:TextView = itemView.findViewById(R.id.textView)

        init {
            itemView.setOnClickListener{
                when(layoutPosition){
                    0 -> {
                        ARouter.getInstance().build("/demo/constraintLayoutActivity").navigation()
                    }

                }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val container = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item,parent,false)
        return ViewHolder(container)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text =dataSet[position]
    }
}