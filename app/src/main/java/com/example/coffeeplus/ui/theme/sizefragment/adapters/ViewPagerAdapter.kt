package com.example.coffeeplus.ui.theme.sizefragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.coffeeplus.databinding.ItemPagerBinding

class ViewPagerAdapter(private val dataList: List<PriceData>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerViewHolder {
        val binding = ItemPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.onBind(dataList[position])

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewPagerViewHolder(private val binding: ItemPagerBinding) : ViewHolder(binding.root) {
        fun onBind(data: PriceData) {
            binding.bPrice.text = data.price
            val adapter=ChildViewPagerAdapter()
            binding.rvPager.adapter=adapter
            binding.rvPager.layoutManager=LinearLayoutManager(itemView.context)
            adapter.addList(data.description)
        }

    }


}

data class PriceData(
    val size: String,
    val price: String,
    val description:List<Description>
)