package com.example.coffeeplus.ui.theme.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.coffeeplus.R
import com.example.coffeeplus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
        customizeBottomNavAppearance()
    }

    private fun setupBottomNavigation() {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHost.navController


        binding.bnvHome.setupWithNavController(navController)
        binding.bnvHome.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.qr -> {
                    navController.navigate(R.id.sizeFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun customizeBottomNavAppearance() {
        val colorState = ContextCompat.getColorStateList(this, R.color.bottom_back_color)
        binding.bnvHome.itemIconTintList = colorState
        binding.bnvHome.itemTextColor = colorState
    }
}
