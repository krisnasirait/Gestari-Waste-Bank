package com.eros.gestariwastebank.main.home.pricelist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.eros.gestariwastebank.databinding.FragmentMetalBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.home.pricelist.adapter.AllCatalogAdapter
import com.eros.gestariwastebank.main.home.pricelist.viewmodel.MetalCatalogViewModel
import com.eros.gestariwastebank.main.home.transaction.AddTransactionDialogFragment
import io.reactivex.disposables.Disposable


class MetalFragment : Fragment() {

    private lateinit var binding: FragmentMetalBinding
    private lateinit var disposeable: Disposable
    private lateinit var allCatalogAdapter: AllCatalogAdapter

    private val viewModel: MetalCatalogViewModel by activityViewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(requireContext())
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMetalBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        binding.rvFragmentMetal.adapter = allCatalogAdapter
        binding.rvFragmentMetal.layoutManager = GridLayoutManager(context, 2)
        viewModel.catalog.observe(requireActivity()) {
            allCatalogAdapter.addAll(it!!)
        }
        viewModel.getCatalogMetal()
    }
}