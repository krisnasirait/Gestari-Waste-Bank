package com.eros.gestariwastebank.main.home.transaction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.eros.gestariwastebank.R
import com.eros.gestariwastebank.databinding.ActivityTransactionBinding
import com.eros.gestariwastebank.main.home.pricelist.ui.AllFragment

class TransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentTransaction) as NavHostFragment
        val navController = navHostFragment.navController

        binding.llSemua.setOnClickListener {
            navController.navigate(R.id.rvFragmentAll)
        }
    }
}