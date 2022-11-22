package com.eros.gestariwastebank.main.home.pricelist.ui.all

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.eros.gestariwastebank.data.model.catalog.Catalog
import com.eros.gestariwastebank.databinding.FragmentAllBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.home.pricelist.ui.all.adapter.AllCatalogAdapter
import com.eros.gestariwastebank.main.home.pricelist.ui.all.viewmodel.AllCatalogViewModel

class AllFragment : Fragment() {


    private lateinit var binding: FragmentAllBinding

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
        allCatalogAdapter = AllCatalogAdapter()
        binding.rvFragmentAll.adapter = allCatalogAdapter
        binding.rvFragmentAll.layoutManager = GridLayoutManager(context, 2)
        viewModel.catalog.observe(requireActivity()) {
            allCatalogAdapter.addAll(it!!)
        }
        viewModel.getCatalog()
    }


}