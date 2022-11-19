package com.eros.gestariwastebank.main.home.tambahsampah

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eros.gestariwastebank.R

class AdapterItem : RecyclerView.Adapter<AdapterItem.ItemHolder>() {
    private var category: ArrayList<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_data, parent, false)
        )
    }
    fun addCategory(category: ArrayList<String>){
        this.category.addAll(category)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
    }

    override fun getItemCount(): Int = category.size
    inner class ItemHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
        }
    }
}