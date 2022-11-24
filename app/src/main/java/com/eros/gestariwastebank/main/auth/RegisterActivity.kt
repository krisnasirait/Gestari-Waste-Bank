package com.eros.gestariwastebank.main.auth

import android.content.Intent
import android.os.Bundle
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

        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.btnRegister.setOnClickListener {
            val fullName = binding.etFullName.text.toString()
            val address = binding.etAdress.text.toString()
            val phone = binding.etPhone.text.toString()
            val email = binding.etEmail.text.toString()
            val birthdate = binding.etBirthdate.text.toString()
            val birthPlace = binding.etBirthPlace.text.toString()
            val nik = binding.etNik.text.toString()
            val password = binding.etPassword.text.toString()
            val confPassword = binding.etConfPassword.text.toString()

            val request = RegisterRequest(fullName, address, phone, email, birthdate, birthPlace, nik, password)
            if(password != confPassword) {
                binding.tvPrompt.text = "Your password is not same"
            }

            viewModel.getRegister(request).observe(this@RegisterActivity){response ->
                if (response?.status.toString() == "success") {
                    Toast.makeText(this, "Register success", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,LoginActivity::class.java))
                } else {
                    Toast.makeText(this, "Register failed", Toast.LENGTH_SHORT).show()
                }
            }


        }
    }
}