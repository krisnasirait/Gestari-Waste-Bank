package com.eros.gestariwastebank.main.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
import com.eros.gestariwastebank.databinding.ActivityRegisterBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.auth.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by viewModels(
        factoryProducer = {
            ViewModelFactory.getInstance(this)
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lottieView.visibility = View.GONE
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.btnRegister.setOnClickListener {
            binding.lottieView.visibility = View.GONE
            val fullName = binding.etFullName.text.toString()
            val phone = binding.etPhone.text.toString()
            val email = binding.etEmail.text.toString()
            val nik = binding.etNik.text.toString()
            val password = binding.etPassword.text.toString()
            val confPassword = binding.etConfPassword.text.toString()

            val resCheck = checkAllFields(fullName, phone, email, nik, password, confPassword)

            if (resCheck) {
                val request = RegisterRequest(fullName, phone, email, nik, password)
                sentReq(request)
            }
        }
    }

    //use function isFormValid() in RegisterViewModel to check all fields are valid before sending request to server
    private fun checkAllFields(
        fullName: String,
        phone: String,
        email: String,
        nik: String,
        password: String,
        confPassword: String
    ): Boolean {
        return if (viewModel.isFormValid(fullName, phone, email, nik, password, confPassword)) {
            true
        } else {
            Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun sentReq(request: RegisterRequest) {
        viewModel.isLoading.observe(this@RegisterActivity) { isLoading ->
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
        viewModel.getRegister(request).observe(this@RegisterActivity) { response ->
            if (response?.status.toString() == "success") {
                Toast.makeText(this, "Register success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                Toast.makeText(this, "Register failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}