package com.example.coffeeplus.ui.theme.homeFragment.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeplus.R
import com.example.coffeeplus.databinding.FragmentHomeBinding
import com.example.coffeeplus.ui.theme.CoffeeNameAndImage
import com.example.coffeeplus.ui.theme.Lists
import com.example.coffeeplus.ui.theme.homeFragment.adapters.ListAdapter


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var adapter = ListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        clickAdapter()
    }


    private fun setAdapter() {
        val listChild = listOf(
            CoffeeNameAndImage(R.drawable.ic_home, "vouiljkbo;l", "hvouhv pijboib"),
            CoffeeNameAndImage(R.drawable.ic_home, "vouiljkbo;l", "hvouhv pijboib"),
            CoffeeNameAndImage(R.drawable.ic_home, "vouiljkbo;l", "hvouhv pijboib"),
            CoffeeNameAndImage(R.drawable.ic_home, "vouiljkbo;l", "hvouhv pijboib")
        )
        val list = listOf(
            Lists("Yaxinliqda", listChild),
            Lists("Yaxinliqda", listChild)
        )
        binding.rvHome.adapter = adapter
        binding.rvHome.layoutManager = LinearLayoutManager(context)
        adapter.addList(list)

    }


    private fun clickAdapter() {
        adapter.setOnClickListener(object : ListAdapter.Listener {
            override fun onClickListener(data: CoffeeNameAndImage) {
                findNavController().navigate(R.id.action_homeFragment_to_menuFragment)
            }

        })
    }

}