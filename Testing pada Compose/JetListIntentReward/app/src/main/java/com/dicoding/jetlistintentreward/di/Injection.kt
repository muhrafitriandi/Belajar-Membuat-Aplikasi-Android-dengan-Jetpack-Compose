package com.dicoding.jetlistintentreward.di

import com.dicoding.jetlistintentreward.data.RewardRepository


object Injection {
    fun provideRepository(): RewardRepository {
        return RewardRepository.getInstance()
    }
}