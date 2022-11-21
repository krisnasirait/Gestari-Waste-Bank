package com.eros.gestariwastebank.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eros.gestariwastebank.data.Util
import com.eros.gestariwastebank.databinding.FragmentHomeBinding
import com.eros.gestariwastebank.main.home.artikel.ArtikelAdapter
import com.eros.gestariwastebank.main.home.pricelist.PricelistActivity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var artikelAdapter: ArtikelAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        artikelAdapter = ArtikelAdapter()

        binding.rvHome.adapter = artikelAdapter

        binding.rvHome.layoutManager =
            LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )

        artikelAdapter.setData(Util.allArtikel)

        binding.btnPricelist.setOnClickListener {
            startActivity(Intent(context, PricelistActivity::class.java))
        }
    }

}