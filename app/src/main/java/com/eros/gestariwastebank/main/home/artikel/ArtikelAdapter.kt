package com.eros.gestariwastebank.main.home.artikel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eros.gestariwastebank.databinding.ItemArtikelBinding

class ArtikelAdapter : RecyclerView.Adapter<ArtikelAdapter.ViewHolder>() {

    private lateinit var binding: ItemArtikelBinding
    private val listArtikel = mutableListOf<Artikel>()

    inner class ViewHolder(private val itemBinding: ItemArtikelBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(artikel: Artikel) {
            itemBinding.tvArtikelTitle.text = artikel.title
//            itemBinding.tvDesc.text = artikel.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(listArtikel[position])
    }

    override fun getItemCount(): Int {
        return listArtikel.size
    }

    fun setData(item: List<Artikel>) {
        listArtikel.addAll(item)
        notifyDataSetChanged()
    }


}