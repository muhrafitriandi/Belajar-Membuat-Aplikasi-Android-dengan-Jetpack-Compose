package com.dicoding.jetlistintentrewardnavhosttesting.di

import com.dicoding.jetlistintentrewardnavhosttesting.data.RewardRepository


object Injection {
    fun provideRepository(): RewardRepository {
        return RewardRepository.getInstance()
    }
}