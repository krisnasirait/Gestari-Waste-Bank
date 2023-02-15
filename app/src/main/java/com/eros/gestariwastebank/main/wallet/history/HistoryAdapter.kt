package com.eros.gestariwastebank.main.wallet.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.eros.gestariwastebank.R
import com.eros.gestariwastebank.databinding.RvItemHistoryBinding
import io.reactivex.subjects.PublishSubject

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private val listHistory = mutableListOf<History>()
    private val clickSubject = PublishSubject.create<History>()
    val clickEvent: io.reactivex.Observable<History> = clickSubject

    inner class ViewHolder(private val itemBinding: RvItemHistoryBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(history: History) {
            with(itemBinding) {
                tvStatus.text = history.status
                tvDate.text = history.tanggal
                if(tvStatus.text == "Penyetoran") {
                    tvAmountMoney.setTextColor(ContextCompat.getColor(tvAmountMoney.context, R.color.medium_green))
                    tvAmountMoney.text = "+ " + history.amount.toString()
                } else {
                    tvAmountMoney.setTextColor(ContextCompat.getColor(tvAmountMoney.context, R.color.red))
                    tvAmountMoney.text = "- " + history.amount.toString()
                }
                root.setOnClickListener { clickSubject.onNext(history) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        listHistory[position].let {
            holder.bind(it)
            holder.itemView.setOnClickListener {
                clickSubject.onNext(listHistory[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return listHistory.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<History>) {
        listHistory.clear()
        listHistory.addAll(items)
        notifyDataSetChanged()
    }

}