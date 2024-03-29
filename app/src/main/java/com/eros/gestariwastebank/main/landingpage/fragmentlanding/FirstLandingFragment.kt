package com.eros.gestariwastebank.main.landingpage.fragmentlanding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eros.gestariwastebank.databinding.FragmentFirstLandingBinding

class FirstLandingFragment : Fragment() {

    private lateinit var binding: FragmentFirstLandingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstLandingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}