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
import com.eros.gestariwastebank.main.auth.viewmodel.LoginState
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
        val loginCred = LoginRequest(viewModel.getEmail(), viewModel.getPassword())

        viewModel.login(loginCred)

        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is LoginState.Success -> {
                    val response = state.response
                    binding.tvNama.text = response?.login?.user?.name.toString()
                    binding.tvNoTlp.text = response?.login?.user?.phone.toString()
                    binding.tvEmail.text = response?.login?.user?.email.toString()
                    binding.tvId.text = "UID: " + response?.login?.user?.id.toString()
                    val formAmount = NumberFormat.getNumberInstance(Locale.US).format(response?.login?.user?.balance)
                    binding.tvBalance.text = "Rp. $formAmount.00"
                }
                else -> {
                    // Handle other states if necessary
                }
            }
        }
    }

    private fun setOnClickListener() {
        binding.btnLogOut.setOnClickListener {
            viewModel.clearCredentials()
            Intent(context, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
    }

}