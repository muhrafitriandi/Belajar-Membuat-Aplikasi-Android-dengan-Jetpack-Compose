package com.dicoding.jetlistreward.ui.screen.cart

import com.dicoding.jetlistreward.model.OrderReward

data class CartState(
    val orderReward: List<OrderReward>,
    val totalRequiredPoint: Int
)