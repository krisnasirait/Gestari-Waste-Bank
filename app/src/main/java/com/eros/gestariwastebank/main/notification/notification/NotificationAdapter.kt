package com.eros.gestariwastebank.main.notification.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eros.gestariwastebank.databinding.ItemNotificationBinding

class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.ViewHolder>(){

    private lateinit var binding: ItemNotificationBinding
    private val listNotification = mutableListOf<Notification>()

    inner class ViewHolder(private val itemBinding: ItemNotificationBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(notification: Notification) {
            itemBinding.tvDate.text = notification.date
            itemBinding.tvTime.text = notification.clock
            itemBinding.tvDescription.text = notification.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listNotification[position])
    }

    override fun getItemCount(): Int {
       return listNotification.size
    }

    fun setData(item: List<Notification>) {
        listNotification.addAll(item)
        notifyDataSetChanged()
    }
}