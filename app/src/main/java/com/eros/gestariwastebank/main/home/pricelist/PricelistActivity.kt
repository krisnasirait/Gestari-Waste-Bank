package com.eros.gestariwastebank.main.home.pricelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eros.gestariwastebank.databinding.ActivityPricelistBinding

class PricelistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPricelistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPricelistBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}