package com.eros.gestariwastebank.main.home.pricelist.ui.plastic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.eros.gestariwastebank.databinding.FragmentPlasticBinding
import com.eros.gestariwastebank.main.home.pricelist.ui.all.viewmodel.AllCatalogViewModel


class PlasticFragment : Fragment() {
    private var _binding: FragmentPlasticBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlasticBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}