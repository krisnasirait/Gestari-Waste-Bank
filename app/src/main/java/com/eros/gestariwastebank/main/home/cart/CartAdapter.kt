package com.eros.gestariwastebank.main.home.cart

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eros.gestariwastebank.data.model.cart.Cart
import com.eros.gestariwastebank.databinding.RvItemCartBinding
import java.text.NumberFormat
import java.util.*

class CartAdapter : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    private lateinit var binding: RvItemCartBinding
    private val itemCart = mutableListOf<Cart?>()

    inner class ViewHolder(private val itemBinding: RvItemCartBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(cart: Cart) {
            itemBinding.tvItemName.text = cart.name
            itemBinding.tvPrice.text = "Rp " + NumberFormat.getNumberInstance(Locale.US).format(cart.price?.toInt()).toString()
            Glide.with(binding.root)
                .load(cart.itemImage)
                .into(itemBinding.ivItem)
            itemBinding.tvQuantity.text = "Quantity : ${cart.amount} kg"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RvItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        itemCart[position]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return itemCart.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(item: List<Cart?>) {
        itemCart.addAll(item)
        notifyDataSetChanged()
    }
}