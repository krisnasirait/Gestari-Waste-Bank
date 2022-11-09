package com.eros.gestariwastebank.main.wallet.history

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eros.gestariwastebank.databinding.ItemHistoryBinding

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private lateinit var binding: ItemHistoryBinding
    private val listHistory = mutableListOf<History>()

    inner class ViewHolder(private val itemBinding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(history: History) {
            itemBinding.tvStatus.text = history.status
            itemBinding.tvDate.text = history.tanggal
            if(itemBinding.tvStatus.text == "Penyetoran") {
                itemBinding.tvAmountMoney.setTextColor(Color.GREEN)
                itemBinding.tvAmountMoney.text = "+ " + history.amount.toString()
            } else {
                itemBinding.tvAmountMoney.setTextColor(Color.RED)
                itemBinding.tvAmountMoney.text = "- " + history.amount.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listHistory[position])
    }

    override fun getItemCount(): Int {
        return listHistory.size
    }

    fun setData(item: List<History>) {
        listHistory.addAll(item)
        notifyDataSetChanged()
    }

}