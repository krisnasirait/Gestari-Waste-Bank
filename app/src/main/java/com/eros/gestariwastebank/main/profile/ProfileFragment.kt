package com.eros.gestariwastebank.main.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eros.gestariwastebank.databinding.FragmentProfileBinding
import com.eros.gestariwastebank.main.auth.LoginActivity


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnLogOut.setOnClickListener {
            val sharedPreferences = this.activity?.getSharedPreferences("prefGWA", 0)
            sharedPreferences?.edit()?.putString("isLogin", "")?.apply()

            Intent(context, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
    }

}