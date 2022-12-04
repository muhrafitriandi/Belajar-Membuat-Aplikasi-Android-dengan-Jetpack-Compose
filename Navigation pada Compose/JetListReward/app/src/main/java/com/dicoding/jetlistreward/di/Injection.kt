package com.dicoding.jetlistreward.di

import com.dicoding.jetlistreward.data.RewardRepository


object Injection {
    fun provideRepository(): RewardRepository {
        return RewardRepository.getInstance()
    }
}