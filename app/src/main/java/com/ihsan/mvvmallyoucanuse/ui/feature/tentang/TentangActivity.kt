package com.ihsan.mvvmallyoucanuse.ui.feature.tentang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ihsan.mvvmallyoucanuse.MainActivity
import com.ihsan.mvvmallyoucanuse.R
import kotlinx.android.synthetic.main.activity_tentang.*

class TentangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang)

        back.setOnClickListener {
        onBackPressed()
        }
    }
}