package com.vall.kisahnabi.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.vall.kisahnabi.DetailActivity
import com.vall.kisahnabi.databinding.ItemRecyclerRasulBinding
import com.vall.kisahnabi.model.ResponseNabiRasulItem

class RasulAdapter : RecyclerView.Adapter<RasulAdapter.ViewHolder>() {

    private val listData: ArrayList<ResponseNabiRasulItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(getData: List<ResponseNabiRasulItem>) {
        listData.clear()
        listData.addAll(getData)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemRecyclerRasulBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerRasulBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]

        holder.binding.tvRasul.text = data.nama
        holder.binding.imgRasul.load(data.avatar)
        holder.binding.tvDeskRasul.text = data.deskripsi

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DATA, data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listData.size
}