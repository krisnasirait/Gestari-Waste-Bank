package com.eros.gestariwastebank.main.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eros.gestariwastebank.data.Util
import com.eros.gestariwastebank.databinding.FragmentWalletBinding
import com.eros.gestariwastebank.main.wallet.history.HistoryAdapter


class WalletFragment : Fragment() {

    private lateinit var binding: FragmentWalletBinding
    private lateinit var historyAdapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
    }
}