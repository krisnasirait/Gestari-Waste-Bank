package com.eros.gestariwastebank.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.eros.gestariwastebank.data.Util
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.databinding.FragmentHomeBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.auth.viewmodel.LoginViewModel
import com.eros.gestariwastebank.main.home.artikel.ArtikelAdapter
import com.eros.gestariwastebank.main.home.pricelist.PricelistActivity
import java.text.NumberFormat
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var artikelAdapter: ArtikelAdapter

    private val viewModel: LoginViewModel by activityViewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(requireContext())
        }
    )

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

        setOnClickListener()
        getData()
    }

    private fun getData() {
        val sharedPreferences = activity?.getSharedPreferences("prefGWA", 0)
        val loginEmail = sharedPreferences?.getString("savedMail", "")
        val loginPassword = sharedPreferences?.getString("savedPass", "")

        val loginCred = LoginRequest(loginEmail, loginPassword)

        viewModel.getLogin(loginCred).observe(requireActivity()){ response ->
            val formAmount = NumberFormat.getNumberInstance(Locale.US).format(response?.data?.user?.balance)
            binding.totalBalance.text = "Rp. $formAmount.00"
        }

    }

    private fun setOnClickListener() {
        binding.btnPricelist.setOnClickListener {
            startActivity(Intent(context, PricelistActivity::class.java))
        }
    }

}