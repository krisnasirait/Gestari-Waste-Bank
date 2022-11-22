package com.eros.gestariwastebank.main.home.pricelist.ui.all.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eros.gestariwastebank.data.model.catalog.Catalog
import com.eros.gestariwastebank.databinding.RvItemCatalogBinding

class AllCatalogAdapter : RecyclerView.Adapter<AllCatalogAdapter.AllCatalogViewHolder>() {

    private val itemCatalog = mutableListOf<Catalog?>()

    inner class AllCatalogViewHolder(
        val binding: RvItemCatalogBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(catalogData: Catalog) {
            binding.tvName.text = catalogData.name
            binding.tvPrice.text = catalogData.price.toString()
            binding.tvSatuan.text = catalogData.satuan
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCatalogViewHolder {
        return AllCatalogViewHolder(
            RvItemCatalogBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AllCatalogViewHolder, position: Int) {
        itemCatalog[position]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return itemCatalog.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(item : List<Catalog?>) {
        itemCatalog.addAll(item)
        notifyDataSetChanged()
    }

    fun clearData(){
        itemCatalog.clear()
    }
}