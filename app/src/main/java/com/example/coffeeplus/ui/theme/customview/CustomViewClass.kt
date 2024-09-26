package com.example.coffeeplus.ui.theme.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeplus.R
import com.example.coffeeplus.databinding.CustomViewXmlBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CustomViewClass @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding: CustomViewXmlBinding

    init {
        binding = CustomViewXmlBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setUpViewPager(adapter: RecyclerView.Adapter<*>, tabTitles: List<String>) {
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    fun tabClick() {
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
