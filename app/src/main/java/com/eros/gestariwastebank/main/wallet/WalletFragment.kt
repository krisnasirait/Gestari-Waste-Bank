package com.eros.gestariwastebank.main.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.eros.gestariwastebank.data.Util
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.databinding.FragmentWalletBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.auth.viewmodel.LoginViewModel
import com.eros.gestariwastebank.main.wallet.history.HistoryAdapter
import java.text.NumberFormat
import java.util.*


class WalletFragment : Fragment() {

    private lateinit var binding: FragmentWalletBinding
    private lateinit var historyAdapter: HistoryAdapter

    private val viewModel: LoginViewModel by activityViewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(requireContext())
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWalletBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historyAdapter = HistoryAdapter()

        binding.rvHistory.adapter = historyAdapter

        binding.rvHistory.layoutManager =
            LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )

        historyAdapter.setData(Util.allHistory)
        getData()
    }

    private fun getData() {
        val sharedPreferences = activity?.getSharedPreferences("prefGWA", 0)
        val loginEmail = sharedPreferences?.getString("savedMail", "")
        val loginPassword = sharedPreferences?.getString("savedPass", "")

        val loginCred = LoginRequest(loginEmail, loginPassword)

        viewModel.getLogin(loginCred).observe(requireActivity()){ response ->
            val formAmount = NumberFormat.getNumberInstance(Locale.US).format(response?.data?.user?.balance)
            binding.tvTotalBalance.text = "Rp. $formAmount.00"
        }

    }
}