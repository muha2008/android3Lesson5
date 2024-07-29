package com.example.android3lesson5.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3lesson5.data.remote.models.ResultsItem
import com.example.android3lesson5.data.repositories.TitanRepository
import com.example.android3lesson5.utils.UIState

class TitanViewModel:ViewModel() {

    private val repository = TitanRepository()

    private val _titansState = MutableLiveData<UIState<List<ResultsItem>>>()
    val titansState: LiveData<UIState<List<ResultsItem>>> = _titansState

    init {
        getTitan()
    }

    private fun getTitan() {
        repository.fetchTitan(
            onResponse = { data ->
                _titansState.value = UIState(isLoading = false, success = data)
            },
            onFailure = { error ->
                _titansState.value = UIState(isLoading = false, error = error.message)
            }
        )
    }
}