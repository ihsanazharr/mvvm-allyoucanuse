package com.ihsan.mvvmallyoucanuse.ui.module.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ihsan.mvvmallyoucanuse.core.data.source.local.DummyData
import com.ihsan.mvvmallyoucanuse.core.data.source.model.Barang

class HomeViewModel : ViewModel() {

    val listProduct: LiveData<List<Barang>> = MutableLiveData<List<Barang>>().apply {
        value = DummyData.listBarang
    }
}