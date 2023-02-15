package com.eros.gestariwastebank.main.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.eros.gestariwastebank.MainActivity
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.databinding.ActivityLoginBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.auth.viewmodel.LoginState
import com.eros.gestariwastebank.main.auth.viewmodel.LoginViewModel
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        setOnClickListener()
    }

    override fun onStart() {
        super.onStart()
        val email = viewModel.getEmail()
        val password = viewModel.getPassword()
        if (email != null && password != null) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }
    }

    private fun setOnClickListener() {
        binding.lottieView.visibility = View.GONE

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.etEmail.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                val imm = v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v.windowToken, 0)
            }
        }

        binding.etPassword.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                val imm = v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v.windowToken, 0)
            }
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (viewModel.isFormValid(email, password)) {
                val request = LoginRequest(email, password)
                viewModel.login(request)
            }
        }

        viewModel.state.observe(this@LoginActivity) { state ->
            when (state) {
                is LoginState.Loading -> {
                    binding.lottieView.visibility = View.VISIBLE
                }
                is LoginState.Success -> {
                    viewModel.saveCredentials(binding.etEmail.text.toString(), binding.etPassword.text.toString())
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }
                is LoginState.Error -> {
                    binding.lottieView.visibility = View.VISIBLE
                    binding.lottieView.setAnimation("121635-failed.json")
                    binding.lottieView.repeatCount = 0
                    binding.lottieView.playAnimation()
                    binding.lottieView.postDelayed({
                        binding.lottieView.visibility = View.GONE
                    }, 1500)
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}