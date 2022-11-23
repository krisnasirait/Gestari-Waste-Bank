package com.eros.gestariwastebank.main.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.eros.gestariwastebank.MainActivity
import com.eros.gestariwastebank.data.model.login.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.ApiClient
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.databinding.ActivityLoginBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.main.auth.viewmodel.LoginViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // TODO: Prompt Should be added here
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            val request = LoginRequest(email, password)

            viewModel.getLogin(request).observe(this@LoginActivity) {
                if (it != null) {
                    val sharedPreferences = getSharedPreferences("prefGWA", 0)
                    sharedPreferences?.edit()?.putString("isLogin", "true")?.apply()
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                } else {
                    Log.d("loginNull : ", "data null")
                }
            }

//            execLoginCall(request)
        }
    }

//    private fun execLoginCall(request: LoginRequest) {
//        ApiClient.instance.loginUserApi(request).enqueue(object : Callback<LoginResponse> {
//            override fun onResponse(
//                call: Call<LoginResponse>,
//                response: Response<LoginResponse>
//            ) {
//                // the response variable contains whole response
//                val sharedPreferences = getSharedPreferences("prefGWA", 0)
//                sharedPreferences?.edit()?.putString("isLogin", "true")?.apply()
//                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                Toast.makeText(this@LoginActivity, t.message.toString(), Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//        })
//    }


}