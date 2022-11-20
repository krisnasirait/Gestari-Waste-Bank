package com.eros.gestariwastebank.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eros.gestariwastebank.MainActivity
import com.eros.gestariwastebank.data.remote.ApiClient
import com.eros.gestariwastebank.data.remote.ApiService
import com.eros.gestariwastebank.databinding.ActivityLoginBinding
import com.eros.gestariwastebank.networking.request.LoginRequest
import com.eros.gestariwastebank.networking.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            val request = LoginRequest(email, password)

            execLoginCall(request)
        }
    }

    private fun execLoginCall(request: LoginRequest) {
        val retrofit = ApiClient.getInstance()
        val apiService = retrofit.create(ApiService::class.java)
        val call  = apiService.loginUser(request)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                // the response variable contains whole response
                startActivity(Intent(this@LoginActivity,MainActivity::class.java))
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity,t.message.toString(), Toast.LENGTH_SHORT).show()
            }

        })
    }
}