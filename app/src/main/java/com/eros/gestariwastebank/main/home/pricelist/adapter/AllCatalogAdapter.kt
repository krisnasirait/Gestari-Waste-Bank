package com.eros.gestariwastebank.main.home.pricelist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eros.gestariwastebank.data.model.cart.Cart
import com.eros.gestariwastebank.data.model.catalog.Catalog
import com.eros.gestariwastebank.databinding.RvItemCatalogBinding
import io.reactivex.subjects.PublishSubject
import java.text.NumberFormat
import java.util.*
import kotlin.properties.Delegates

class AllCatalogAdapter : RecyclerView.Adapter<AllCatalogAdapter.AllCatalogViewHolder>() {

    private val itemCatalog = mutableListOf<Catalog?>()
    private val clickSubject = PublishSubject.create<Catalog>()
    val clickEvent: io.reactivex.Observable<Catalog> = clickSubject

    inner class AllCatalogViewHolder(
        val binding: RvItemCatalogBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(catalogData: Catalog) {
            Glide.with(binding.root)
                .load(catalogData.image)
                .into(binding.ivStuffImage)
            binding.tvCategory.text = catalogData.type
            binding.tvName.text = catalogData.name
            binding.tvPrice.text = NumberFormat.getNumberInstance(Locale.US).format(catalogData.price).toString() + "-/"
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
        itemCatalog[position]?.let {
            holder.bind(it)
            holder.binding.fabAdd.setOnClickListener {
                clickSubject.onNext(itemCatalog[position]!!)
            }
            holder.itemView.setOnClickListener {
                clickSubject.onNext(itemCatalog[position]!!)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemCatalog.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(item: List<Catalog?>) {
        itemCatalog.addAll(item)
        notifyDataSetChanged()
    }
}