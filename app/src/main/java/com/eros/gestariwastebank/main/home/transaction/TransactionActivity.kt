package com.eros.gestariwastebank.main.home.transaction

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.eros.gestariwastebank.R
import com.eros.gestariwastebank.databinding.ActivityTransactionBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.home.cart.CartActivity
import com.eros.gestariwastebank.main.home.pricelist.viewmodel.AllCatalogViewModel
import com.eros.gestariwastebank.main.home.transaction.viewmodel.AddTranscationViewModel
import kotlin.math.log

class TransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionBinding

    fun getTvAmount(): TextView {
        return binding.tvAmount
    }

    private val viewModel: AddTranscationViewModel by viewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(this)
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_transaction) as NavHostFragment
        val navController = navHostFragment.navController

        binding.llSemua.setOnClickListener {
            navController.navigate(R.id.fragment_all)
        }

        binding.llKertas.setOnClickListener {
            navController.navigate(R.id.fragment_paper)
        }

        binding.llPlastik.setOnClickListener {
            navController.navigate(R.id.fragment_plastic)
        }

        binding.llKaca.setOnClickListener {
            navController.navigate(R.id.fragment_kaca)
        }

        binding.llLogam.setOnClickListener {
            navController.navigate(R.id.fragment_metal)
        }

        binding.llLain.setOnClickListener {
            navController.navigate(R.id.fragment_others)
        }

        binding.ivCart.setOnClickListener{
            startActivity(Intent(this, CartActivity::class.java))
        }


        viewModel.totalItem.observe(this, {
            binding.tvAmount.text = it.toString()
        })
        viewModel.getRowCount()

    }
}