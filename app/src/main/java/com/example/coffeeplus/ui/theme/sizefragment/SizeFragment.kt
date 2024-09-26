package com.example.coffeeplus.ui.theme.sizefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.coffeeplus.R
import com.example.coffeeplus.databinding.FragmentSizeBinding
import com.example.coffeeplus.ui.theme.sizefragment.adapters.Description
import com.example.coffeeplus.ui.theme.sizefragment.adapters.PriceData
import com.example.coffeeplus.ui.theme.sizefragment.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class SizeFragment : Fragment() {
    private lateinit var binding: FragmentSizeBinding
    private lateinit var adapter: ViewPagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSizeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mbPayment.setOnClickListener {
            findNavController().navigate(R.id.action_sizeFragment_to_paymentFragment)
        }
        setUpViewPager()
        tabClick()
    }


    private val list = listOf(
        PriceData(
            "S size", "60 AZN",
            listOf(
                Description(
                    R.drawable.ic_point, "Partnyor satış nöqtələrindən ən sevdiyini  seç"
                ),
                Description(R.drawable.ic_point, "QR kodu oxut və istədiyin kofeni əldə et"),
                Description(R.drawable.ic_point, "Gün ərzində 1 dəfə bu imkandan faydalan"),
                Description(
                    R.drawable.ic_point,
                    "Vaxt periodu 00:00-12:00 və 12:00-00:00 olaraq nəzərə alınır"
                )
            )
        ),
        PriceData(
            "M size", "100 AZN", listOf(
                Description(R.drawable.ic_point,"Partnyor satış nöqtələrindən ən sevdiyini  seç"),
                Description(R.drawable.ic_point,"QR kodu oxut və istədiyin kofeni əldə et"),
                Description(R.drawable.ic_point,"Gün ərzində 2 dəfə bu imkandan faydalan"),
                Description(
                    R.drawable.ic_point,"Vaxt periodu 00:00-12:00 və 12:00-00:00 olaraq nəzərə alınır"
                )
            )
        )
    )

    private fun setUpViewPager() {
        adapter = ViewPagerAdapter(list)
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = list[position].size
        }.attach()

        binding.viewPager2.post {
            binding.tabLayout.getTabAt(0)?.select()
            binding.viewPager2.setCurrentItem(0, false)
        }

    }

    private fun tabClick() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.view?.setBackgroundResource(R.drawable.shape_tablayout)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.view?.setBackgroundResource(android.R.color.transparent)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}