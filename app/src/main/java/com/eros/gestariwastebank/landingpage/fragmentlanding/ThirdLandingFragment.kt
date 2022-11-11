package com.eros.gestariwastebank.landingpage.fragmentlanding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eros.gestariwastebank.R
import com.eros.gestariwastebank.auth.LoginActivity
import com.eros.gestariwastebank.auth.RegisterActivity
import com.eros.gestariwastebank.databinding.FragmentThirdLandingBinding

class ThirdLandingFragment : Fragment() {

    private lateinit var binding: FragmentThirdLandingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdLandingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnLogin.setOnClickListener {
            Intent(context, LoginActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnRegister.setOnClickListener {
            Intent(context, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}