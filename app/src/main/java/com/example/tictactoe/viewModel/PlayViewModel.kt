package com.example.tictactoe.viewModel

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tictactoe.item.BoardButton

class PlayViewModel(application: Application) : AndroidViewModel(application) {
    val _refreshLiveData = MutableLiveData<Boolean>()
    var isWinLiveData = MutableLiveData<Boolean>()
    val refreshLiveData: LiveData<Boolean>
        get() {
            return _refreshLiveData
        }

    init {
    }

    fun win(arr:Array<Array<BoardButton?>>): Boolean {
// ===============================================================
        var _isWin = false
        for (i in arr.indices) {
            val type = arr[i][0]?.type
            for (j in arr.indices) {
                _isWin = true
                if (arr[i][j]?.type != type || arr[i][j] == null) {
                    _isWin = false
                    break
                }
            }
            if (_isWin) {
                isWinLiveData.value = true
                return true
            }
        }

        // ===============================================================
        for (i in arr.indices) {
            val type = arr[0][i]?.type
            for (j in arr.indices) {
                _isWin = true
                if (arr[j][i]?.type != type || arr[j][i] == null) {
                    _isWin = false
                    break
                }
            }
            if (_isWin) {
                isWinLiveData.value = true
                return true
            }
        }

        // ===============================================================
        for (i in arr.indices) {
            val type = arr[0][0]?.type
            _isWin = true
            if (arr[i][i]?.type != type || arr[i][i] == null) {
                _isWin = false

                break
            }
        }

        if (_isWin) {
            isWinLiveData.value = true
            return true
        }

        // ===============================================================
        for (i in arr.indices) {
            val type = arr[0][arr.size - 1]?.type
            _isWin = true
            if (arr[i][arr.size - 1 - i]?.type != type || arr[i][arr.size - 1 - i] == null) {
                _isWin = false
                break
            }
        }

        if (_isWin) {
            isWinLiveData.value = true
            return true
        }
        // ===============================================================

        return false
    }

    fun refresh() {
        _refreshLiveData.value = true
    }
}