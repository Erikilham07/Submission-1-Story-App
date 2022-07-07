package com.dicoding.mystoryapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dicoding.mystoryapp.data.repository.MainRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: MainRepository) : ViewModel() {

    fun setToken(token: String, isLogin: Boolean){
        viewModelScope.launch {
            repo.setToken(token, isLogin)
        }
    }

    fun getToken() : LiveData<String> {
        return repo.getToken().asLiveData()
    }

    fun login(email: String, password: String) = repo.login(email, password)
}