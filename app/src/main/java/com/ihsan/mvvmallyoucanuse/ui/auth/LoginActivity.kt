package com.ihsan.mvvmallyoucanuse.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ihsan.mvvmallyoucanuse.NavigationActivity
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.network.State
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.request.LoginRequest
import com.ihsan.mvvmallyoucanuse.databinding.ActivityLoginBinding
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel : AuthViewModel by viewModel()
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        mainButton()
    }

    private fun mainButton(){

        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    private fun setData() {

    }

    private fun login(){

        if(binding.edtEmailLogin.isEmpty()) return
        if(binding.edtPasswordLogin.isEmpty()) return

        val body = LoginRequest(
            binding.edtEmailLogin.getString(),
            binding.edtPasswordLogin.getString()
        )

        viewModel.login(body).observe(this, {

            when(it.state){
                State.SUCCESS ->{
//                    dismisLoading()
                    showToast("Selamat Datang " +it.data?.name)
                    pushActivity(NavigationActivity::class.java)
                }
                State.ERROR -> {
//                    dismisLoading()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
                    showLoading()
                }
            }

        })
    }
}