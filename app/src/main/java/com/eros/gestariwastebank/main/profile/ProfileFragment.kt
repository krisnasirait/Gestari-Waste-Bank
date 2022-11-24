package com.eros.gestariwastebank.main.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.databinding.FragmentProfileBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.auth.LoginActivity
import com.eros.gestariwastebank.main.auth.viewmodel.LoginViewModel
import java.text.NumberFormat
import java.util.*


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val viewModel: LoginViewModel by activityViewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(requireContext())
        }
    )

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

        getData()
        setOnClickListener()
    }

    private fun getData() {
        val sharedPreferences = activity?.getSharedPreferences("prefGWA", 0)
        val loginEmail = sharedPreferences?.getString("savedMail", "")
        val loginPassword = sharedPreferences?.getString("savedPass", "")

        val loginCred = LoginRequest(loginEmail, loginPassword)

        viewModel.getLogin(loginCred).observe(requireActivity()){ response ->
            binding.tvNama.text = response?.login?.user?.name.toString()
            binding.tvNoTlp.text = response?.login?.user?.phone.toString()
            binding.tvAlamat.text = response?.login?.user?.address.toString()
            binding.tvEmail.text = response?.login?.user?.email.toString()
            val formAmount = NumberFormat.getNumberInstance(Locale.US).format(response?.login?.user?.balance)
            binding.tvBalance.text = "Rp. $formAmount.00"
        }

    }

    private fun setOnClickListener() {
        binding.btnLogOut.setOnClickListener {
            val sharedPreferences = this.activity?.getSharedPreferences("prefGWA", 0)
            sharedPreferences?.edit()?.putString("isLogin", "")?.apply()
            sharedPreferences?.edit()?.putString("savedMail", "")?.apply()
            sharedPreferences?.edit()?.putString("savedPass", "")?.apply()

            Intent(context, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
    }

}