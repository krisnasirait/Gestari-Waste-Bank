package com.eros.gestariwastebank.main.home.cart

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eros.gestariwastebank.R
import com.eros.gestariwastebank.data.model.cart.Cart
import com.eros.gestariwastebank.databinding.RvItemCartBinding
import com.eros.gestariwastebank.main.home.transaction.viewmodel.AddTranscationViewModel
import io.reactivex.subjects.PublishSubject
import java.text.NumberFormat
import java.util.*

class CartAdapter(
    private val addTranscationViewModel: AddTranscationViewModel
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemCart = mutableListOf<Cart?>()

    private val clickSubject = PublishSubject.create<Cart>()
    val clickEvent: io.reactivex.Observable<Cart> = clickSubject

    inner class CartViewHolder(
        val binding: RvItemCartBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cart: Cart) {
            val itemPrice = cart.price?.toInt()
            val itemAmount = cart.amount?.toInt()
            val totalGet = itemPrice?.times(itemAmount ?: 0)
            binding.tvItemName.text = cart.name
            binding.tvPrice.text =
                "Rp " + NumberFormat.getNumberInstance(Locale.US).format(cart.price?.toInt())
                    .toString()
            Glide.with(binding.root)
                .load(cart.itemImage)
                .into(binding.ivItem)
            binding.tvYouWillGet.text = "Rp " + NumberFormat.getNumberInstance(Locale.US)
                .format(totalGet)
                .toString()
            binding.tvTrashAmount.text = "${cart.amount}"
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
            holder.binding.btnMinus.setOnClickListener {
                addTranscationViewModel.decreaseAmount(itemCart[position]?.id!!)
                itemCart[position]?.amount = itemCart[position]?.amount?.minus(1)
                addTranscationViewModel.getTotalGet()
                notifyDataSetChanged()
            }
            holder.binding.btnPlus.setOnClickListener {
                addTranscationViewModel.increaseAmount(itemCart[position]?.id!!)
                itemCart[position]?.amount = itemCart[position]?.amount?.plus(1)
                addTranscationViewModel.getTotalGet()
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return itemCart.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(item: List<Cart?>) {
        itemCart.clear()
        itemCart.addAll(item)
        notifyDataSetChanged()
    }
}