package com.eros.gestariwastebank.landingpage.fragmentlanding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eros.gestariwastebank.R
import com.eros.gestariwastebank.databinding.FragmentFirstLandingBinding
import com.eros.gestariwastebank.databinding.FragmentSecondLandingBinding

class SecondLandingFragment : Fragment() {

    private lateinit var binding: FragmentSecondLandingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondLandingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}