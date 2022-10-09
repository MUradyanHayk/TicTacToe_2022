package com.example.tictactoe.viewModel

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PlayViewModel(application: Application) : AndroidViewModel(application) {
    val _refreshLiveData = MutableLiveData<Boolean>()
    val refreshLiveData: LiveData<Boolean>
        get() {
            return _refreshLiveData
        }

    init {
    }

    fun refresh() {
        _refreshLiveData.value = true
    }
}