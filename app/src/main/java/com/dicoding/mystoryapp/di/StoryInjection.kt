package com.dicoding.mystoryapp.di

import com.dicoding.mystoryapp.data.repository.StoryRepository
import com.dicoding.mystoryapp.data.retrofit.ApiConfig

object StoryInjection {
    fun provideRepository(): StoryRepository {
        val apiService = ApiConfig.getApiService()
        return StoryRepository.getInstance(apiService)
    }
}