package com.moontowertickets.randomuser.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moontowertickets.randomuser.domain.repository.UserRepository
import com.moontowertickets.randomuser.domain.util.Resource
import com.moontowertickets.randomuser.ui.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomUserViewModel @Inject constructor(
    private val randomUserApi: UserRepository
):ViewModel() {
    var state by mutableStateOf(UserState())
        private set

    fun getRandomUser() {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)
            state = when(val result = randomUserApi.getUsers()) {

                is Resource.Success -> {
                    Log.i("RandomUserViewModel", "getRandomUser: ${result.data}")
                    state.copy(isLoading = false, users = result.data , error = null)
                }
                is Resource.Error -> {
                    Log.i("RandomUserViewModel", "getRandomUser: ${result.message}")
                    state.copy(isLoading = false, error = result.message, users = null)
                }
            }
        }
    }
}