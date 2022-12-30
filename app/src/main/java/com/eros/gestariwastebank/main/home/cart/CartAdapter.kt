package com.eros.gestariwastebank.main.home.cart

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eros.gestariwastebank.data.model.cart.Cart
import com.eros.gestariwastebank.databinding.RvItemCartBinding
import io.reactivex.subjects.PublishSubject
import java.text.NumberFormat
import java.util.*

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemCart = mutableListOf<Cart?>()
    private val clickSubject = PublishSubject.create<Cart>()
    val clickEvent: io.reactivex.Observable<Cart> = clickSubject

    inner class CartViewHolder(
        val itemBinding: RvItemCartBinding
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(cart: Cart) {
            itemBinding.tvItemName.text = cart.name
            itemBinding.tvPrice.text =
                "Rp " + NumberFormat.getNumberInstance(Locale.US).format(cart.price?.toInt())
                    .toString()
            Glide.with(itemBinding.root)
                .load(cart.itemImage)
                .into(itemBinding.ivItem)
            itemBinding.tvTrashAmount.text = "${cart.amount}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            RvItemCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        itemCart[position]?.let {
            holder.bind(it)
            holder.itemBinding.btnMinus.setOnClickListener {
                clickSubject.onNext(itemCart[position]!!)
            }
            holder.itemBinding.btnPlus.setOnClickListener {
                clickSubject.onNext(itemCart[position]!!)
            }
        }
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