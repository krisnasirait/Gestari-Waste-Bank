package com.eros.gestariwastebank.main.home.pricelist.ui.paper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.eros.gestariwastebank.databinding.FragmentMetalBinding
import com.eros.gestariwastebank.databinding.FragmentPaperBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.home.pricelist.ui.all.adapter.AllCatalogAdapter
import com.eros.gestariwastebank.main.home.pricelist.ui.all.viewmodel.AllCatalogViewModel
import com.eros.gestariwastebank.main.home.pricelist.ui.metal.viewmodel.MetalCatalogViewModel
import com.eros.gestariwastebank.main.home.pricelist.ui.paper.viewmodel.PaperViewModel


class PaperFragment : Fragment() {
    private lateinit var binding: FragmentPaperBinding

    private lateinit var allCatalogAdapter: AllCatalogAdapter

    private val viewModel: PaperViewModel by activityViewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(requireContext())
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPaperBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allCatalogAdapter = AllCatalogAdapter()
        binding.rvFragmentPaper.adapter = allCatalogAdapter
        binding.rvFragmentPaper.layoutManager = GridLayoutManager(context, 2)
        viewModel.catalog.observe(requireActivity()) {
            allCatalogAdapter.addAll(it!!)
        }
        viewModel.getCatalogPaper()
    }
}