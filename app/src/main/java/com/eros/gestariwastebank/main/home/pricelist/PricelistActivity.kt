package com.eros.gestariwastebank.main.home.pricelist

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.eros.gestariwastebank.R
import com.eros.gestariwastebank.databinding.ActivityPricelistBinding

class PricelistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPricelistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPricelistBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}