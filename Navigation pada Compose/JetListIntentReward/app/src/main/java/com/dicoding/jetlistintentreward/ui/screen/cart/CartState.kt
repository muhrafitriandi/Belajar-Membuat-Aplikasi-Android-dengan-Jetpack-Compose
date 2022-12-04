package com.dicoding.jetlistintentreward.ui.screen.cart

import com.dicoding.jetlistintentreward.model.OrderReward

data class CartState(
    val orderReward: List<OrderReward>,
    val totalRequiredPoint: Int
)