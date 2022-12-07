package com.example.courierapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courierapp.data.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
): ViewModel() {

    private val _accessToken = MutableStateFlow<String?>(null)
    val accessToken: StateFlow<String?> = _accessToken.asStateFlow()

    private val _isLoading = MutableLiveData<Boolean>(true)
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepository.readAccessToken().collect { token ->
                _accessToken.value = token
                _isLoading.postValue(false)
            }
        }
    }

    fun saveTokenDataStore(accessToken: String) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepository.saveAccessToken(accessToken)
        }
    }
}