package com.ihsan.mvvmallyoucanuse.ui.module.ruangan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ihsan.mvvmallyoucanuse.core.data.source.model.Barang
import com.ihsan.mvvmallyoucanuse.core.data.source.model.Ruangan
import com.ihsan.mvvmallyoucanuse.databinding.ItemRowBarangBinding
import com.ihsan.mvvmallyoucanuse.databinding.ItemRowRuanganBinding

class RuanganAdapter : RecyclerView.Adapter<RuanganAdapter.ViewHolder>() {

    private var data = ArrayList<Ruangan>()

    inner class ViewHolder(private val itemBinding : ItemRowRuanganBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item: Ruangan, position: Int){
            itemBinding.apply {
                tvNamaRuangan.text = item.name
                imgRuangan.setImageResource(item.image)
            }
        }
    }

    fun addItems(items: List<Ruangan>){
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRowRuanganBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}