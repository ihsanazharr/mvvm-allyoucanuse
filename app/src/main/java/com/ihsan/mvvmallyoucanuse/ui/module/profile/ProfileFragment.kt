package com.ihsan.mvvmallyoucanuse.ui.module.profile

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.ihsan.mvvmallyoucanuse.NavigationActivity
import com.ihsan.mvvmallyoucanuse.R
import com.ihsan.mvvmallyoucanuse.databinding.FragmentProfileBinding
import com.ihsan.mvvmallyoucanuse.ui.module.BottomSheet
import com.ihsan.mvvmallyoucanuse.ui.feature.bantuan.BantuanActivity
import com.ihsan.mvvmallyoucanuse.ui.feature.tentang.TentangActivity
import com.ihsan.mvvmallyoucanuse.util.Constants.USER_URL
import com.ihsan.mvvmallyoucanuse.util.Prefs
import com.inyongtisto.myhelper.extension.getInitial
import com.inyongtisto.myhelper.extension.pushActivity
import com.squareup.picasso.Picasso

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUser()
        mainButton()
        return root
    }

    override fun onResume() {
        setUser()
        super.onResume()
    }


    fun mainButton(){

        binding.btnTentang.setOnClickListener {
            val intent = Intent(context, TentangActivity::class.java)
            startActivity(intent)
        }

        binding.btnBantuan.setOnClickListener {
            val intent = Intent(context, BantuanActivity::class.java)
            startActivity(intent)
        }
        binding.btnEditprofil.setOnClickListener {
            val bottomSheet = BottomSheet()
            val fragmentManager = (activity as FragmentActivity).supportFragmentManager
            fragmentManager?.let { bottomSheet.show(it, BottomSheet.TAG) }
        }

        binding.btnLogout.setOnClickListener {

            val dialog = Dialog(context!!)

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setContentView(R.layout.custom_dialog)

            val btnCancel = dialog.findViewById<Button>(R.id.btnCancel)
            val btnLogout = dialog.findViewById<Button>(R.id.btnYes)


            btnLogout.setOnClickListener {
                Prefs.isLogin = false
                pushActivity(NavigationActivity::class.java)
            }

            btnCancel.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }

    }

    private fun setUser() {
        val user = Prefs.getUser()
        if(user != null){
            binding.apply {
                tvNama.text = user.name
                tvNisn.text = user.nis
                tvEmail.text = user.email
                tvInisial.text = user.name.getInitial()

                Picasso.get().load(USER_URL + user.image).into(binding.imageProfile)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}