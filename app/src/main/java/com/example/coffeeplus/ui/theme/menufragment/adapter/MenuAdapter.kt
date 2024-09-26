package com.example.coffeeplus.ui.theme.menufragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.coffeeplus.databinding.ImageListMenuBinding

class MenuAdapter() : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private lateinit var binding: ImageListMenuBinding
    private var dataList = mutableListOf<MenuImageList>()
    private var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        binding= ImageListMenuBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) {
       holder.onBind(dataList[position],listener)
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    class MenuViewHolder(private var binding: ImageListMenuBinding) : ViewHolder(binding.root) {
        fun onBind(data: MenuImageList, listener: Listener?){
            binding.ivMenuImage.setImageResource(data.image)
            binding.ivMenuImage.setOnClickListener{
                listener?.onClickListener(data)
            }
        }
    }

    fun addList(newList:List<MenuImageList>){
        dataList.clear()
        dataList.addAll(newList)
        notifyDataSetChanged()
    }


    interface Listener {
        fun onClickListener(data: MenuImageList)
    }

    fun setOnClickListener(listener: Listener) {
        this.listener = listener
    }
}

data class MenuImageList(
    var image: Int
)