package com.bam.viewmodelexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bam.viewmodelexample.R
import com.bam.viewmodelexample.databinding.UserItemBinding
import com.bam.viewmodelexample.room.UserData

class UserEntityListAdapter : RecyclerView.Adapter<UserEntityListAdapter.ViewHolder>() {

    var items: List<UserData> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var itemClick: (UserData) -> Unit = {}
    fun itemClick(listener: (UserData) -> Unit) {
        itemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.user = items[position]
        holder.itemView.setOnClickListener {
            itemClick(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = UserItemBinding.bind(view)

    }
}