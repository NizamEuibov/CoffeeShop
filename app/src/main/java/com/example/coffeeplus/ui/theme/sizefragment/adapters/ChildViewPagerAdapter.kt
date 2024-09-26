package com.example.coffeeplus.ui.theme.sizefragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.coffeeplus.databinding.ItemDescribtionBinding

class ChildViewPagerAdapter() : RecyclerView.Adapter<ChildViewPagerAdapter.ChildViewHolder>() {
    private lateinit var binding: ItemDescribtionBinding
    private var dataList = mutableListOf<Description>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChildViewPagerAdapter.ChildViewHolder {
        binding = ItemDescribtionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChildViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildViewPagerAdapter.ChildViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    class ChildViewHolder(private var binding: ItemDescribtionBinding) : ViewHolder(binding.root) {

        fun onBind(data: Description) {
            binding.tvDescription.text = data.description
            binding.ivPoint.setImageResource(data.image)
        }

    }

    fun addList(newList: List<Description>) {
        dataList.clear()
        dataList.addAll(newList)
        notifyDataSetChanged()
    }
}


data class Description(val image: Int, val description: String)