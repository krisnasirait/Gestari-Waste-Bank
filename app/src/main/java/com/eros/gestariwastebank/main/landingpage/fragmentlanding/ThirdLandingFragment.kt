package com.eros.gestariwastebank.main.landingpage.fragmentlanding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eros.gestariwastebank.main.auth.LoginActivity
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
        binding.btnLetsStart.setOnClickListener {

            val sharedPreferences = this.activity?.getSharedPreferences("prefGWA", 0)
            sharedPreferences?.edit()?.putString("isFirst", "false")?.apply()

            Intent(context, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}