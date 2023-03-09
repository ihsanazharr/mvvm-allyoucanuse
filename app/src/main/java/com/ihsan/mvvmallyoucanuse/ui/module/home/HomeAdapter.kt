package com.ihsan.mvvmallyoucanuse.ui.module.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ihsan.mvvmallyoucanuse.core.data.source.local.DummyData
import com.ihsan.mvvmallyoucanuse.core.data.source.model.Barang
import com.ihsan.mvvmallyoucanuse.databinding.ItemRowBarangBinding
import com.ihsan.mvvmallyoucanuse.ui.module.detailHalaman.DetailBarangActivity

class HomeAdapter (var barang: List<DummyData>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var data = ArrayList<Barang>()

    inner class ViewHolder(private val itemBinding : ItemRowBarangBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item: Barang, position: Int){
            itemBinding.apply {
                tvNamaBarang.text = item.name
                tvStok.text = item.stok.toString() + " Pcs"
                imgBarang.setImageResource(item.image)
            }
        }
    }

    fun addItems(items: List<Barang>){
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRowBarangBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailBarangActivity::class.java)
            intent.putExtra("name", data[position].name)
            intent.putExtra("stok", data[position].stok)
            intent.putExtra("deskripsi", data[position].deskripsi)
            intent.putExtra("image", data[position].image)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}