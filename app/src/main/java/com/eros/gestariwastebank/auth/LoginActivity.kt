package com.eros.gestariwastebank.auth

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eros.gestariwastebank.MainActivity
import com.eros.gestariwastebank.R
import com.eros.gestariwastebank.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setOnClickListener()

        
    }
    
    private fun setOnClickListener() {
        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // TODO: Prompt Should be added here 
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text
            val password = binding.etPassword.text

            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}