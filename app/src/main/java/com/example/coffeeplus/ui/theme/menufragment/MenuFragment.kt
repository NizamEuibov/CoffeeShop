package com.example.coffeeplus.ui.theme.menufragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeplus.R
import com.example.coffeeplus.databinding.FragmentMenuBinding
import com.example.coffeeplus.ui.theme.menufragment.adapter.MenuAdapter
import com.example.coffeeplus.ui.theme.menufragment.adapter.MenuImageList


class MenuFragment : Fragment() {
    private lateinit var binding:FragmentMenuBinding
    private val adapter =MenuAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentMenuBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterSet()
    }

    private fun adapterSet(){
        val list = listOf(
            MenuImageList(R.drawable.icon9_background),
            MenuImageList(R.drawable.icon9_background),
            MenuImageList(R.drawable.icon9_background)
        )
        binding.rvMenuImage.adapter=adapter
        binding.rvMenuImage.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        adapter.addList(list)

        binding.bSubscription.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_sizeFragment)
        }
    }

}