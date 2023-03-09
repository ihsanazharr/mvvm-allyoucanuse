package com.ihsan.mvvmallyoucanuse.ui.feature.bantuan

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ihsan.mvvmallyoucanuse.R
import kotlinx.android.synthetic.main.activity_bantuan.*

class BantuanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bantuan)


        back.setOnClickListener {
            onBackPressed()
        }

        cv_redirect.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ihsanazharr"))
            startActivity(intent)
        }
    }
}