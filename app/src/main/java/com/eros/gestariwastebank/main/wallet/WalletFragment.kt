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
import io.reactivex.disposables.Disposable
import java.text.NumberFormat
import java.util.*


class WalletFragment : Fragment() {

    private lateinit var binding: FragmentWalletBinding
    private lateinit var historyAdapter: HistoryAdapter
    private lateinit var disposeable: Disposable

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
        disposeable = historyAdapter.clickEvent.subscribe { item ->
            val status = item.status
            val date = item.tanggal
            val amount = NumberFormat.getNumberInstance(Locale.US).format(item.amount)
            val bundle = Bundle()

            bundle.putString("status", status)
            bundle.putString("date", date)
            bundle.putString("amount", amount)

            val dialog = HistoryDialogFragment()
            dialog.show(childFragmentManager, "HistoryDialogFragment")

            dialog.arguments = bundle
        }

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

        val loginCred = LoginRequest(viewModel.getEmail(), viewModel.getPassword())

        viewModel.getLogin(loginCred).observe(requireActivity()){ response ->
            val formAmount = NumberFormat.getNumberInstance(Locale.US).format(response?.login?.user?.balance)
            binding.tvTotalBalance.text = "Rp. $formAmount.00"
        }

    }
}
