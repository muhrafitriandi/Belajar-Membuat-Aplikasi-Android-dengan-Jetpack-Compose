package com.dicoding.jetlistintentrewardnavhosttesting.ui.screen.cart

import com.dicoding.jetlistintentrewardnavhosttesting.model.OrderReward

data class CartState(
    val orderReward: List<OrderReward>,
    val totalRequiredPoint: Int
)