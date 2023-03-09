package com.ihsan.mvvmallyoucanuse.ui.module.ruangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ihsan.mvvmallyoucanuse.R
import com.ihsan.mvvmallyoucanuse.core.data.source.local.DummyData
import com.ihsan.mvvmallyoucanuse.core.data.source.model.Ruangan
import com.ihsan.mvvmallyoucanuse.databinding.ActivityRuanganBinding
import com.ihsan.mvvmallyoucanuse.databinding.FragmentHomeBinding
import com.ihsan.mvvmallyoucanuse.ui.module.home.HomeAdapter
import com.ihsan.mvvmallyoucanuse.ui.module.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_bantuan.*
import kotlinx.android.synthetic.main.activity_bantuan.back
import kotlinx.android.synthetic.main.activity_ruangan.*

class RuanganActivity : AppCompatActivity() {

    private lateinit var viewModel: RuanganViewModel
    private lateinit var binding: ActivityRuanganBinding
    private val adapterRuangan = RuanganAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRuanganBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(RuanganViewModel::class.java)

        back.setOnClickListener {
            onBackPressed()
        }

        setupAdapter()
        setData()
    }

    private fun setupAdapter(){
        binding.rvRuangan.adapter = adapterRuangan
    }

    private fun setData(){
        viewModel.listRuangan.observe(this, {
            adapterRuangan.addItems(it)
        })
    }
}