package com.eros.gestariwastebank.main.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.eros.gestariwastebank.R
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
import com.eros.gestariwastebank.databinding.ActivityRegisterBinding
import com.eros.gestariwastebank.di.ViewModelFactory
import com.eros.gestariwastebank.domain.validate.*
import com.eros.gestariwastebank.main.auth.viewmodel.RegisterViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private val name = MutableStateFlow("")
    private val phone = MutableStateFlow("")
    private val email = MutableStateFlow("")
    private val nik = MutableStateFlow("")
    private val password = MutableStateFlow("")
    private val passwordAgain = MutableStateFlow("")

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
            binding.lottieView.visibility = View.GONE
            val fullName = binding.etFullName.text.toString()
            val phone = binding.etPhone.text.toString()
            val email = binding.etEmail.text.toString()
            val nik = binding.etNik.text.toString()
            val password = binding.etPassword.text.toString()
            val confPassword = binding.etConfPassword.text.toString()

            val resCheck = checkAllFields(fullName, phone, email, nik, password, confPassword)

            if (resCheck == true) {
                val request = RegisterRequest(fullName, phone, email, nik, password)
                sentReq(request)
            }
        }
    }

    private fun checkAllFields(name:String, phone: String, email: String, nik: String, password:String, confPass:String) : Boolean{
        if (password != confPass && password.isNotBlank() && confPass.isNotBlank()) {
            binding.etConfPassword.error = "Konfirmasi tidak sama!"
            binding.etConfPassword.setBackgroundResource(R.drawable.bg_auth_red)
            return false
        }
        if (nik.length > 12 && nik.isNotBlank() && nik.length < 12) {
            binding.etNik.error = "NIK tidak valid!"
            binding.etNik.setBackgroundResource(R.drawable.bg_auth_red)
            return false
        }
        if (phone.length < 10 && phone.isNotBlank()) {
            binding.etPhone.error = "No telp tidak valid"
            binding.etPhone.setBackgroundResource(R.drawable.bg_auth_red)
            return false
        }
        if (phone.isBlank() || email.isBlank() || name.isBlank() || nik.isBlank() || password.isBlank() || confPass.isBlank()) {
            binding.etPhone.error = "Data tidak boleh kosong!"
            binding.etPhone.setBackgroundResource(R.drawable.bg_auth_red)

            binding.etEmail.error = "Data tidak boleh kosong!"
            binding.etEmail.setBackgroundResource(R.drawable.bg_auth_red)

            binding.etFullName.error = "Data tidak boleh kosong!"
            binding.etFullName.setBackgroundResource(R.drawable.bg_auth_red)

            binding.etNik.error = "Data tidak boleh kosong!"
            binding.etNik.setBackgroundResource(R.drawable.bg_auth_red)

            binding.etPassword.error = "Data tidak boleh kosong!"
            binding.etPassword.setBackgroundResource(R.drawable.bg_auth_red)

            binding.etConfPassword.error = "Data tidak boleh kosong!"
            binding.etConfPassword.setBackgroundResource(R.drawable.bg_auth_red)
            return false
        }

        return true
    }

    private fun sentReq(request: RegisterRequest) {
        viewModel.isLoading.observe(this@RegisterActivity) { isLoading ->
            if(!isLoading) {
                binding.lottieView.visibility = View.GONE
            } else {
                binding.lottieView.visibility = View.VISIBLE
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