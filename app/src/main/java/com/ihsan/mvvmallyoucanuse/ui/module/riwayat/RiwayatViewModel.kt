package com.ihsan.mvvmallyoucanuse.ui.module.riwayat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RiwayatViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is riwayat Fragment"
    }
    val text: LiveData<String> = _text
}