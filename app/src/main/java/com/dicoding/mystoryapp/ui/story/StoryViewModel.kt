package com.dicoding.mystoryapp.ui.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.mystoryapp.data.repository.StoryRepository
import com.dicoding.mystoryapp.data.repository.MainRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody

class StoryViewModel(private val userRepo: MainRepository, private val storyRepo: StoryRepository) : ViewModel() {

    fun getToken() : LiveData<String> {
        return userRepo.getToken().asLiveData()
    }

    fun uploadStory(token: String, imageMultipart: MultipartBody.Part, desc: RequestBody) = storyRepo.uploadStory(token, imageMultipart, desc)
}