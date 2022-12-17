package com.eros.gestariwastebank.main.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.eros.gestariwastebank.data.Util
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.databinding.FragmentHomeBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.auth.viewmodel.LoginViewModel
import com.eros.gestariwastebank.main.home.artikel.NewsAdapter
import com.eros.gestariwastebank.main.home.artikel.viewmodel.NewsViewModel
import com.eros.gestariwastebank.main.home.pricelist.PricelistActivity
import java.text.NumberFormat
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var newsAdapter: NewsAdapter

    private val viewModel: LoginViewModel by activityViewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(requireContext())
        }
    )

    private val newsViewModel: NewsViewModel by activityViewModels(
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

        setOnClickListener()
        getDataLogin()
        getNews()
    }

    private fun getNews() {
        newsAdapter = NewsAdapter()
        binding.rvArticle.adapter = newsAdapter
        binding.rvArticle.layoutManager =
            LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        newsViewModel.news.observe(requireActivity()) {
            newsAdapter.addAll(it!!)
        }
        newsViewModel.getNews()
    }

    private fun getDataLogin() {

        val loginCred = LoginRequest(viewModel.getEmail(), viewModel.getPassword())

        viewModel.getLogin(loginCred).observe(requireActivity()){ response ->
//            val formAmount = NumberFormat.getNumberInstance(Locale.US).format(response?.login?.user?.balance)
            binding.totalBalance.text = "Rp. ${response?.login?.user?.balance.toString()} .00"
            Log.d("amountBalance", "getDataLogin: ${response?.login?.user?.balance}")
            binding.tvGreetings.text = "Welcome, ${response?.login?.user?.name}"
        }

    }

    private fun setOnClickListener() {
        binding.btnPricelist.setOnClickListener {
            startActivity(Intent(context, PricelistActivity::class.java))
        }
    }

}