package com.example.recyclerview.data

import androidx.annotation.DrawableRes

data class Flower(
    val id: Long,
    val name: String,
    val unicode: Int,
    @DrawableRes
    val image: Int?
)
