package com.eros.gestariwastebank.main.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.eros.gestariwastebank.MainActivity
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.databinding.ActivityLoginBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.auth.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(this)
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        checkLoginInfo()
        setOnClickListener()
    }

    private fun checkLoginInfo() {
        val sharedPreferences = getSharedPreferences("prefGWA", 0)
        val isLogin = sharedPreferences.getString("isLogin", "")
        // Shared preference Login
        if (!isLogin.isNullOrEmpty()) {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun setOnClickListener() {
        binding.lottieView.visibility = View.GONE

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // TODO: Prompt Should be added here
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            val request = LoginRequest(email, password)
            viewModel.isLoading.observe(this@LoginActivity) { isLoading ->
                when (isLoading) {
                    "loading" -> {
                        binding.lottieView.visibility = View.VISIBLE
                    }
                    "success" -> {
                        binding.lottieView.visibility = View.GONE
                    }
                    else -> {
                        binding.lottieView.visibility = View.VISIBLE
                        binding.lottieView.setAnimation("121635-failed.json")
                        binding.lottieView.repeatCount = 0
                        binding.lottieView.playAnimation()
                        binding.lottieView.postDelayed({
                            binding.lottieView.visibility = View.GONE
                        }, 1500)

                    }
                }
            }

            viewModel.getLogin(request).observe(this@LoginActivity) {
                if (it != null) {
                    val sharedPreferences = getSharedPreferences("prefGWA", 0)
                    sharedPreferences?.edit()?.putString("isLogin", "true")?.apply()
                    sharedPreferences?.edit()?.putString("savedMail", email)?.apply()
                    sharedPreferences?.edit()?.putString("savedPass", password)?.apply()
                    Log.d("namaUser", it.login?.user?.name.toString())
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }
            }

        }
    }


}