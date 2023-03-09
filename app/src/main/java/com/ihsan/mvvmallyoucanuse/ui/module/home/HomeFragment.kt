package com.ihsan.mvvmallyoucanuse.ui.module.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ihsan.mvvmallyoucanuse.databinding.FragmentHomeBinding
import com.ihsan.mvvmallyoucanuse.ui.module.ruangan.RuanganActivity
import com.ihsan.mvvmallyoucanuse.ui.module.ruangan.RuanganAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapterBarang = HomeAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupAdapter()
        setData()
        mainButton()
        return root
    }

    fun mainButton(){
        binding.cvRuangan.setOnClickListener {
            val intent = Intent(context, RuanganActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupAdapter(){
        binding.rvAvailable.adapter = adapterBarang
    }

    private fun setData(){
        viewModel.listProduct.observe(requireActivity(), {
            adapterBarang.addItems(it)
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}