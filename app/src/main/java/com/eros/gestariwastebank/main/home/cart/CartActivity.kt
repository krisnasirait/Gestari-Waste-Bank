package com.eros.gestariwastebank.main.home.cart

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eros.gestariwastebank.databinding.ActivityCartBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.home.transaction.viewmodel.AddTranscationViewModel
import io.reactivex.disposables.Disposable

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    private lateinit var cartAdapter: CartAdapter

    private val viewModel: AddTranscationViewModel by viewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(this)
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cartAdapter = CartAdapter(viewModel)
        binding.rvItemCart.adapter = cartAdapter
        binding.rvItemCart.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel.cartItem.observe(this) {
            cartAdapter.addAll(it)
        }
        viewModel.getDataCart()
    }
}