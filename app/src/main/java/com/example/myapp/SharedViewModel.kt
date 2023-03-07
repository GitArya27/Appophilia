package com.example.myapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {
    private val repository = SharedRepository()
    private val _gameByIdLiveData = MutableLiveData<GetGameByIDResponse?>()
    val gameByIdLiveData: LiveData<GetGameByIDResponse?> = _gameByIdLiveData
    fun refreshGame(gameId :Int){
        viewModelScope.launch {
            val response = repository.getGameById(gameId)
            _gameByIdLiveData.postValue(response)

        }
    }
}