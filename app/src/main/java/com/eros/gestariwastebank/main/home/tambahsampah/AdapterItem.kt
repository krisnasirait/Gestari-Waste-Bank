package com.eros.gestariwastebank.main.home.tambahsampah

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eros.gestariwastebank.databinding.RvItemDataBinding
import com.eros.gestariwastebank.main.home.tambahsampah.itemsampah.Sampah

class AdapterItem : RecyclerView.Adapter<AdapterItem.ItemHolder>() {

    private lateinit var binding: RvItemDataBinding
    private val listItem = mutableListOf<Sampah>()

    inner class ItemHolder(private val itemBinding: RvItemDataBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(sampah: Sampah) {
            itemBinding.tvNamaItem.text = sampah.nama
            Glide.with(binding.root)
                .load(sampah.image)
                .into(itemBinding.ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        binding = RvItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(binding)
    }

    override fun getItemCount(): Int = listItem.size

    fun addItem(item: List<Sampah>) {
        listItem.addAll(item)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(listItem[position])
    }

}