package com.eros.gestariwastebank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdapterCategory(var onclick: View.OnClickListener) : RecyclerView.Adapter<AdapterCategory.ItemHolder>() {
    private var category: ArrayList<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCategory.ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_category, parent, false)
        )
    }
    fun addCategory(category: ArrayList<String>){
        this.category.addAll(category)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AdapterCategory.ItemHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = category.size
    inner class ItemHolder(var view: View) : ViewHolder(view) {
        private var title: TextView? = null
        fun bind() {
            title = view.findViewById(R.id.tvText)
            itemView.setOnClickListener {
                onclick.onClick(view)
            }
        }
    }
}