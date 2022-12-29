package com.eros.gestariwastebank.main.home.pricelist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.eros.gestariwastebank.databinding.FragmentAllBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.home.pricelist.adapter.AllCatalogAdapter
import com.eros.gestariwastebank.main.home.pricelist.viewmodel.AllCatalogViewModel
import com.eros.gestariwastebank.main.home.transaction.AddTransactionDialogFragment
import com.eros.gestariwastebank.main.wallet.HistoryDialogFragment
import io.reactivex.disposables.Disposable
import java.text.NumberFormat
import java.util.*

class AllFragment : Fragment() {


    private lateinit var binding: FragmentAllBinding
    private lateinit var disposeable: Disposable
    private lateinit var allCatalogAdapter: AllCatalogAdapter

    private val viewModel: AllCatalogViewModel by activityViewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(requireContext())
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val screenWidth = resources.displayMetrics.widthPixels
        val spanCount = screenWidth / 400 // 180 is the width of each grid item in pixels
        val layoutManager = GridLayoutManager(context, spanCount)
        allCatalogAdapter = AllCatalogAdapter()
        disposeable = allCatalogAdapter.clickEvent.subscribe { item ->
            val itemName = item.name
            val itemId = item.id
            val price = item.price.toString()
            val itemImage = item.image
            val bundle = Bundle()

            bundle.putString("itemName", itemName)
            bundle.putString("itemPrice", price)
            bundle.putString("itemImage", itemImage)
            bundle.putString("itemId", itemId.toString())

            val dialog = AddTransactionDialogFragment()
            dialog.show(childFragmentManager, "AddTransactionDialogFragment")
            dialog.arguments = bundle
        }
        binding.rvFragmentAll.adapter = allCatalogAdapter
        binding.rvFragmentAll.layoutManager = layoutManager
        viewModel.catalog.observe(requireActivity()) {
            allCatalogAdapter.addAll(it!!)
        }
        viewModel.getCatalog()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposeable.dispose()
    }

}