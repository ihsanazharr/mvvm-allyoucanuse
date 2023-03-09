package com.ihsan.mvvmallyoucanuse.ui.feature.updateProfile

import android.app.Activity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.github.drjacky.imagepicker.ImagePicker
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.network.State
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.request.UpdateProfileRequest
import com.ihsan.mvvmallyoucanuse.databinding.ActivityUpdateProfileBinding
import com.ihsan.mvvmallyoucanuse.databinding.ItemBottomSheetBinding
import com.ihsan.mvvmallyoucanuse.ui.auth.AuthViewModel
import com.ihsan.mvvmallyoucanuse.ui.base.MyActivity
import com.ihsan.mvvmallyoucanuse.util.Constants
import com.ihsan.mvvmallyoucanuse.util.Prefs

import com.inyongtisto.myhelper.extension.*
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

class UpdateProfileActivity : MyActivity() {

    private val viewModel : AuthViewModel by viewModel()
    private var _binding: ActivityUpdateProfileBinding? = null
    private val binding get() = _binding!!
    private var fileImage : File?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.toolbar, "Update Foto Profile")

        mainButton()
        setData()
    }

    private fun setData(){
        val user = Prefs.getUser()
        if(user != null){
            binding.apply {
                tvInisial.text = user.name.getInitial()
                Picasso.get().load(Constants.USER_URL + user.image).into(binding.imageProfile)
            }
        }
    }

    private fun mainButton() {

        binding.btnSimpan.setOnClickListener {

            if(fileImage !=null) {
                upload()
                showSuccessDialog("Berhasil", "Foto Profil Berhasil Diubah")
            }else{
                onBackPressed()
            }
        }

        binding.btnCancel.setOnClickListener {
            onBackPressed()
        }

        binding.tvUbahpp.setOnClickListener {
            picImage()
        }

        binding.imageProfile.setOnClickListener {
            picImage()
        }
    }

    private fun picImage(){
        ImagePicker.with(this)
            .crop()
            .maxResultSize(3840, 3840, true)
            .createIntentFromDialog {launcher.launch(it) }
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){
            var uri = it.data?.data!!

            fileImage = File(uri.path!!)
            Picasso.get().load(fileImage!!).into(binding.imageProfile)
            upload()
        }
    }


    private fun upload(){
        val idUser = Prefs.getUser()?.id
        val file = fileImage.toMultipartBody()

        viewModel.uploadUser(idUser, file).observe(this, {
            when(it.state){
                State.SUCCESS ->{
                    onBackPressed()
                }
                State.ERROR -> {
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
                    progress.show()
                }
            }

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}