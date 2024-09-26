package com.example.coffeeplus.ui.theme.homeFragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.coffeeplus.databinding.ItemHomeCoffeelistBinding
import com.example.coffeeplus.ui.theme.CoffeeNameAndImage
import com.example.coffeeplus.ui.theme.Lists

class ListAdapter() : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    private lateinit var binding: ItemHomeCoffeelistBinding
    private val dataList = mutableListOf<Lists>()
    private var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        binding =
            ItemHomeCoffeelistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    inner class ListViewHolder(private val binding: ItemHomeCoffeelistBinding) :
        ViewHolder(binding.root) {

        fun onBind(data: Lists) {
            binding.tvList.text = data.text
            val childAdapter = ChildListAdapter(listener)
            binding.rvHomeCoffeeList.adapter = childAdapter
            binding.rvHomeCoffeeList.layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            childAdapter.addList(data.coffeeNameAndImage)
        }

    }


    fun addList(newList: List<Lists>) {
        dataList.clear()
        dataList.addAll(newList)
        notifyDataSetChanged()

    }


    fun setOnClickListener(listener: Listener) {
        this.listener = listener

    }


    interface Listener {
        fun onClickListener(data: CoffeeNameAndImage)
    }

}