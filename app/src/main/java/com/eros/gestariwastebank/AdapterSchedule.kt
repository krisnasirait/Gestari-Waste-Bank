package com.eros.gestariwastebank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView


class AdapterSchedule(val onclick: (positionSelected: Int) -> Unit) :
    RecyclerView.Adapter<AdapterSchedule.ItemHolder>() {
    private var category: ArrayList<String> = ArrayList()
    private var positionSelected: Int = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterSchedule.ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_schedule, parent, false)
        )
    }

    fun addCategory(category: ArrayList<String>) {
        this.category.addAll(category)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AdapterSchedule.ItemHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = category.size
    inner class ItemHolder(var view: View) : RecyclerView.ViewHolder(view) {
        private var rb: RadioButton? = null

        init {
            rb = view.findViewById(R.id.rb)

        }

        fun bind() {
            rb?.isChecked = positionSelected == layoutPosition
            rb?.setOnCheckedChangeListener { compoundButton, b ->
                val temp = positionSelected

                if (b) {
                    positionSelected = layoutPosition
                }
                this.itemView.post {
                    if (temp >= 0) {
                        notifyItemChanged(temp)
                    }
                    notifyItemChanged(positionSelected)
                }
                onclick(positionSelected)
            }
        }
    }
}