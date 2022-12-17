package com.eros.gestariwastebank.main.home.artikel

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eros.gestariwastebank.data.model.news.News
import com.eros.gestariwastebank.databinding.RvItemArtikelBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private lateinit var binding: RvItemArtikelBinding
    private val itemNews = mutableListOf<News?>()

    inner class ViewHolder(private val itemBinding: RvItemArtikelBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(newsData: News) {
            itemBinding.tvArtikelTitle.text = newsData.title
            Glide.with(binding.root)
                .load(newsData.image)
                .into(itemBinding.ivPoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RvItemArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       itemNews[position]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return itemNews.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(item : List<News?>) {
        itemNews.addAll(item)
        notifyDataSetChanged()
    }


}