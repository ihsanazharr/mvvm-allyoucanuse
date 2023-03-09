package com.ihsan.mvvmallyoucanuse.ui.module.detailHalaman

import android.media.AsyncPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ihsan.mvvmallyoucanuse.R
import com.ihsan.mvvmallyoucanuse.core.data.source.local.DummyData
import com.ihsan.mvvmallyoucanuse.core.data.source.model.Barang
import com.ihsan.mvvmallyoucanuse.databinding.ActivityDetailBinding
import com.ihsan.mvvmallyoucanuse.ui.module.home.HomeAdapter
import com.inyongtisto.myhelper.extension.setToolbar


class DetailBarangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var obj:Barang
    private var barangImg:Int?=null

    companion object {
        const val EXTRA_ITEM = "extra_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar(binding.lyToolbar.toolbar, "")

    }
}