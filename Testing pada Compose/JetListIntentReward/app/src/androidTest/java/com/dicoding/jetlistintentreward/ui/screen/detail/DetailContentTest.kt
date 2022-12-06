package com.dicoding.jetlistintentreward.ui.screen.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.dicoding.jetlistintentreward.model.OrderReward
import com.dicoding.jetlistintentreward.model.Reward
import org.junit.Rule
import com.dicoding.jetlistintentreward.R

class DetailContentTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeOrderReward = OrderReward(
        reward = Reward(4, R.drawable.reward_4, "Jaket Hoodie Dicoding", 7500),
        count = 0
    )
}