package com.ihsan.mvvmallyoucanuse

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ihsan.mvvmallyoucanuse.databinding.ActivityNavigationBinding
import com.ihsan.mvvmallyoucanuse.ui.auth.LoginActivity
import com.ihsan.mvvmallyoucanuse.util.Prefs

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_navigation)

        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {

            if (it.itemId == R.id.navigation_profile){
                if (Prefs.isLogin){
                    Log.d("TAG", "Sudah Login")
                    navController.navigate(it.itemId)
                }else{
                    startActivity(Intent(this, LoginActivity::class.java))
                    Log.d("TAG", "Belum auth, pindah ke menu auth")
                    return@setOnItemSelectedListener false
                }
            }else{
                navController.navigate(it.itemId)
                Log.d("TAG", "onCreate: yg lain" + it.itemId)
            }
            return@setOnItemSelectedListener true
        }
    }

    override fun onBackPressed() {
        val dialog = Dialog(this)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.custom_dialog_exit)

        val btnCancel = dialog.findViewById<Button>(R.id.btnCancel)
        val btnYes = dialog.findViewById<Button>(R.id.btnYes)

        btnYes.setOnClickListener {
            finish()
        }

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}