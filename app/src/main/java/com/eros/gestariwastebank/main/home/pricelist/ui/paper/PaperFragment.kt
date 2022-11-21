package com.eros.gestariwastebank.main.home.pricelist.ui.paper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.eros.gestariwastebank.R
import com.eros.gestariwastebank.databinding.FragmentAllBinding
import com.eros.gestariwastebank.databinding.FragmentPaperBinding
import com.eros.gestariwastebank.main.home.pricelist.ui.all.AllViewModel


class PaperFragment : Fragment() {
    private var _binding: FragmentPaperBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this)[AllViewModel::class.java]

        _binding = FragmentPaperBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvTitle
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}