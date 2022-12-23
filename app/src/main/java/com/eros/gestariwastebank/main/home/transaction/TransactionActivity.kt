package com.eros.gestariwastebank.main.home.transaction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.eros.gestariwastebank.R
import com.eros.gestariwastebank.databinding.ActivityTransactionBinding

class TransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionBinding

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

    }
}