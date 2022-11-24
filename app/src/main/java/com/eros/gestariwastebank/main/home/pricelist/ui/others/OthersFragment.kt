package com.eros.gestariwastebank.main.home.pricelist.ui.others

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.eros.gestariwastebank.databinding.FragmentMetalBinding
import com.eros.gestariwastebank.databinding.FragmentOthersBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.home.pricelist.ui.all.adapter.AllCatalogAdapter
import com.eros.gestariwastebank.main.home.pricelist.ui.all.viewmodel.AllCatalogViewModel
import com.eros.gestariwastebank.main.home.pricelist.ui.metal.viewmodel.MetalCatalogViewModel
import com.eros.gestariwastebank.main.home.pricelist.ui.others.viewmodel.OthersViewModel

class OthersFragment : Fragment() {
    private lateinit var binding: FragmentOthersBinding

    private lateinit var allCatalogAdapter: AllCatalogAdapter

    private val viewModel: OthersViewModel by activityViewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(requireContext())
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOthersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allCatalogAdapter = AllCatalogAdapter()
        binding.rvFragmentOthers.adapter = allCatalogAdapter
        binding.rvFragmentOthers.layoutManager = GridLayoutManager(context, 2)
        viewModel.catalog.observe(requireActivity()) {
            allCatalogAdapter.addAll(it!!)
        }
        viewModel.getCatalogOthers()
    }
}