package com.dicoding.jetlistintentreward.ui.screen.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.dicoding.jetlistintentreward.model.OrderReward
import com.dicoding.jetlistintentreward.model.Reward
import org.junit.Rule
import com.dicoding.jetlistintentreward.R
import com.dicoding.jetlistintentreward.ui.theme.JetRewardTheme
import org.junit.Before

class DetailContentTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeOrderReward = OrderReward(
        reward = Reward(4, R.drawable.reward_4, "Jaket Hoodie Dicoding", 7500),
        count = 0
    )

    @Before
    fun setUp() {
        composeTestRule.setContent {
            JetRewardTheme {
                DetailContent(
                    fakeOrderReward.reward.image,
                    fakeOrderReward.reward.title,
                    fakeOrderReward.reward.requiredPoint,
                    fakeOrderReward.count,
                    onBackClick = {},
                    onAddToCart = {}
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }
}