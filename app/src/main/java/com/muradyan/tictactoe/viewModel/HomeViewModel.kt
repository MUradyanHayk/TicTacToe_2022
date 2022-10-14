package com.muradyan.tictactoe.viewModel

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muradyan.tictactoe.item.BoardButton
import com.muradyan.tictactoe.ui.LineDrawType

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    var _playLiveData = MutableLiveData<Unit>()
    val playLiveData: LiveData<Unit>
        get() {
            return _playLiveData
        }

    init {

    }
}