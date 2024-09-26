package com.example.coffeeplus.ui.theme

data class CoffeeNameAndImage(
    val image:Int,
    val name:String,
    val destination:String
)


data class Lists(
    val text:String,
    val coffeeNameAndImage:List<CoffeeNameAndImage>
)
