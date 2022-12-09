package com.eros.gestariwastebank.main.home.tambahsampah

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eros.gestariwastebank.R


class AdapterSchedule(val onclick: (positionSelected: Int) -> Unit) :
    RecyclerView.Adapter<AdapterSchedule.ItemHolder>() {
    private var schedule: ArrayList<String> = ArrayList()
    private var positionSelected: Int = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_schedule, parent, false)
        )
    }

    fun addSchedule(schedule: ArrayList<String>) {
        this.schedule.addAll(schedule)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = schedule.size
    inner class ItemHolder(var view: View) : RecyclerView.ViewHolder(view) {
        private var rb: RadioButton? = null
        private var title: TextView? = null
        init {
            rb = view.findViewById(R.id.rb)
            title = view.findViewById(R.id.tvText)
        }

        fun bind() {
            title?.text  = schedule[adapterPosition]
            rb?.isChecked = positionSelected == layoutPosition
            rb?.setOnCheckedChangeListener { _, b ->
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