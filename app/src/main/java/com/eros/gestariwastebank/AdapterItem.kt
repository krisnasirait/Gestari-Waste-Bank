package com.eros.gestariwastebank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterItem : RecyclerView.Adapter<AdapterItem.ItemHolder>() {
    private var category: ArrayList<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterItem.ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_data, parent, false)
        )
    }
    fun addCategory(category: ArrayList<String>){
        this.category.addAll(category)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AdapterItem.ItemHolder, position: Int) {
    }

    override fun getItemCount(): Int = category.size
    inner class ItemHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
        }
    }
}