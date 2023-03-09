package com.ihsan.mvvmallyoucanuse.ui.module

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.inyongtisto.myhelper.extension.*
import com.ihsan.mvvmallyoucanuse.R
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.network.State
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.request.UpdateProfileRequest
import com.ihsan.mvvmallyoucanuse.databinding.ItemBottomSheetBinding
import com.ihsan.mvvmallyoucanuse.ui.auth.AuthViewModel
import com.ihsan.mvvmallyoucanuse.ui.feature.updateProfile.UpdateProfileActivity
import com.ihsan.mvvmallyoucanuse.util.Constants
import com.ihsan.mvvmallyoucanuse.util.Prefs
import com.inyongtisto.myhelper.extension.getInitial
import com.inyongtisto.myhelper.extension.int
import com.inyongtisto.myhelper.extension.isEmpty
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

class BottomSheet : BottomSheetDialogFragment() {

    private val viewModel : AuthViewModel by viewModel()
    private var _binding: ItemBottomSheetBinding? = null
    private var fileImage: File? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun getTheme(): Int = R.style.Theme_AppBottomSheetDialogTheme

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = ItemBottomSheetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setData()
        mainButton()
        return root
    }

    private fun setData() {
        val user = Prefs.getUser()
        if(user != null){
            binding.apply {
                tvInisial.text = user.name.getInitial()
                edtNamaLengkap.setText(user.name)
                edtEmail.setText(user.email)
                edtNis.setText(user.nis)

                Picasso.get().load(Constants.USER_URL + user.image).into(binding.imageProfile)
            }
        }
    }

    private fun mainButton() {
        binding.btnSimpan.setOnClickListener {
            update()
        }

        binding.imageProfile.setOnClickListener {
            val intent = Intent(context, UpdateProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){
            var uri = it.data?.data!!
            Picasso.get().load(uri).into(binding.imageProfile)
        }
    }

    private fun update() {

        if (binding.edtNamaLengkap.isEmpty()) return
        if (binding.edtEmail.isEmpty()) return
        if (binding.edtNis.isEmpty()) return

        val idUser = Prefs.getUser()?.id
        val body = UpdateProfileRequest(
            idUser.int(),
            name  = binding.edtNamaLengkap.text.toString(),
            email = binding.edtEmail.text.toString(),
            nis = binding.edtNis.text.toString(),
        )

        viewModel.updateUser(body).observe(this, {

            when(it.state){
                State.SUCCESS ->{
                    showSuccessDialog("Berhasil", "Data Berhasil Diubah")
                }
                State.ERROR -> {
//                    dismisLoading()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {

                }
            }

        })
    }

    companion object{
        const val TAG = "AddRecipientWalletSheet"
    }


}