package com.ihsan.mvvmallyoucanuse.ui.module.ruangan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ihsan.mvvmallyoucanuse.core.data.source.local.DummyData
import com.ihsan.mvvmallyoucanuse.core.data.source.model.Barang
import com.ihsan.mvvmallyoucanuse.core.data.source.model.Ruangan

class RuanganViewModel : ViewModel() {

    val listRuangan: LiveData<List<Ruangan>> = MutableLiveData<List<Ruangan>>().apply {
        value = DummyData.listRuangan
    }
}