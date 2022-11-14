package com.eros.gestariwastebank.auth

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eros.gestariwastebank.MainActivity
import com.eros.gestariwastebank.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

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
            val password = binding.etPassword.text
            val confPassword = binding.etConfPassword.text

            if (password == confPassword) {
                Intent(this, MainActivity::class.java).also {
                    startActivity(it)
                }
            } else {
                binding.tvPrompt.setTextColor(Color.RED)
            }
        }
    }
}