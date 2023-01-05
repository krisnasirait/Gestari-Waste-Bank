package com.eros.gestariwastebank.main.home.cart

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eros.gestariwastebank.databinding.ActivityCartBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.home.transaction.viewmodel.AddTranscationViewModel
import java.text.NumberFormat
import java.util.*

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

        val itemAmount = intent.getStringExtra("itemAmount")

        cartAdapter = CartAdapter(viewModel)
        binding.rvItemCart.adapter = cartAdapter
        binding.rvItemCart.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel.cartItem.observeForever {
            cartAdapter.addAll(it)
        }
        if (itemAmount == "0") {
            binding.ivCartEmpty.visibility = android.view.View.VISIBLE
            binding.tvIsEmpty.visibility = android.view.View.VISIBLE
            binding.rvItemCart.visibility = android.view.View.GONE
            binding.clTime.visibility = android.view.View.GONE
            binding.clSummary.visibility = android.view.View.GONE
            binding.btnConfirm.visibility = android.view.View.GONE
        } else {
            binding.ivCartEmpty.visibility = android.view.View.GONE
            binding.tvIsEmpty.visibility = android.view.View.GONE
            binding.rvItemCart.visibility = android.view.View.VISIBLE
            binding.clTime.visibility = android.view.View.VISIBLE
            binding.clSummary.visibility = android.view.View.VISIBLE
            binding.btnConfirm.visibility = android.view.View.VISIBLE

            viewModel.getDataCart()
            viewModel.getTotalGet()
            viewModel.saldoDapat.observeForever { saldo ->
                val totalGet = saldo.toInt()
                binding.tvSaldoAmount.text = "Rp " + NumberFormat.getNumberInstance(Locale.US)
                    .format(totalGet)
                    .toString()
                viewModel.getTotalGet()
                viewModel.getRowCount()
            }
            viewModel.totalItem.observeForever { jumlah ->
                binding.tvItemAmount.text = "$jumlah"
            }


        }
    }
}