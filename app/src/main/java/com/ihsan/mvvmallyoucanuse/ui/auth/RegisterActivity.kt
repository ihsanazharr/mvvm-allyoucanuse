package com.ihsan.mvvmallyoucanuse.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ihsan.mvvmallyoucanuse.NavigationActivity
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.network.State
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.request.RegisterRequest
import com.ihsan.mvvmallyoucanuse.databinding.ActivityRegisterBinding
import com.ihsan.mvvmallyoucanuse.ui.auth.AuthViewModel

import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {

    private val viewModel : AuthViewModel by viewModel()
    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
    }

    private fun setData() {

        binding.btnDaftar.setOnClickListener {
            register()
        }
    }

    private fun register(){

        if(binding.edtNamalengkap.isEmpty()) return
        if(binding.edtEmail.isEmpty()) return
        if(binding.edtNis.isEmpty()) return
        if(binding.edtPassword.isEmpty()) return


        val body = RegisterRequest(
            binding.edtNamalengkap.text.toString(),
            binding.edtEmail.text.toString(),
            binding.edtNis.text.toString(),
            binding.edtPassword.text.toString()
        )

        viewModel.register(body).observe(this, {

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
//                    showLoading()
                }
            }

        })
    }

}