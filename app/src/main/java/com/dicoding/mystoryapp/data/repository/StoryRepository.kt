package com.dicoding.mystoryapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.dicoding.mystoryapp.data.response.StoriesResponse
import com.dicoding.mystoryapp.data.retrofit.ApiService
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.lang.Exception
import com.dicoding.mystoryapp.data.Result
import com.dicoding.mystoryapp.data.response.UploadStoryResponse

class StoryRepository(private val apiService: ApiService){

    fun getStories(token: String): LiveData<Result<StoriesResponse>> = liveData{
        emit(Result.Loading)
        try {
            val client = apiService.getStories("Bearer $token")
            emit(Result.Success(client))
        }catch (e : Exception){
            Log.d("StoryRepository", "getStories: ${e.message.toString()} ")
            emit(Result.Error(e.message.toString()))
        }
    }

    fun uploadStory(token: String, imageMultipart: MultipartBody.Part, desc: RequestBody): LiveData<Result<UploadStoryResponse>> = liveData{
        emit(Result.Loading)
        try {
            val client = apiService.uploadStory("Bearer $token",imageMultipart, desc)
            emit(Result.Success(client))
        }catch (e : Exception){
            e.printStackTrace()
            Log.d("StoryRepository", "uploadStory: ${e.message.toString()} ")
            emit(Result.Error(e.message.toString()))
        }
    }

    companion object {
        @Volatile
        private var instance: StoryRepository? = null
        fun getInstance(
            apiService: ApiService
        ): StoryRepository =
            instance ?: synchronized(this) {
                instance ?: StoryRepository(apiService)
            }.also { instance = it }
    }
}