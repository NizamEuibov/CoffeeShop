package com.example.coffeeplus.ui.theme.homeFragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.coffeeplus.databinding.CardViewForcoffeeshopBinding
import com.example.coffeeplus.ui.theme.CoffeeNameAndImage

class ChildListAdapter(private val listener: ListAdapter.Listener?) :
    RecyclerView.Adapter<ChildListAdapter.ChildListViewHolder>() {
    private lateinit var binding: CardViewForcoffeeshopBinding
    private var dataList = mutableListOf<CoffeeNameAndImage>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChildListViewHolder {
        binding =
            CardViewForcoffeeshopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChildListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildListViewHolder, position: Int) {
        holder.onBind(dataList[position], listener)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    class ChildListViewHolder(private var binding: CardViewForcoffeeshopBinding) :
        ViewHolder(binding.root) {

        fun onBind(data: CoffeeNameAndImage, listener: ListAdapter.Listener?) {
            with(binding){
            ivCoffeeShop.setImageResource(data.image)
            tvCoffeeShopName.text=data.name
            tvDestination.text=data.destination
                itemView.setOnClickListener{
                    listener?.onClickListener(data)
                }
        }}

    }

    fun addList(newList: List<CoffeeNameAndImage>) {
        dataList.clear()
        dataList.addAll(newList)
        notifyDataSetChanged()
    }
}

