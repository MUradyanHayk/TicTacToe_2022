package com.example.tictactoe.viewModel

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tictactoe.item.BoardButton
import com.example.tictactoe.ui.LineDrawType

class PlayViewModel(application: Application) : AndroidViewModel(application) {
    val _refreshLiveData = MutableLiveData<Boolean>()
    var winTypeLiveData = MutableLiveData<LineDrawType>()
    val refreshLiveData: LiveData<Boolean>
        get() {
            return _refreshLiveData
        }

    init {
    }

    fun win(arr: Array<Array<BoardButton?>>): Boolean {
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
                winTypeLiveData.value = LineDrawType.TYPE_1
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
                winTypeLiveData.value = LineDrawType.TYPE_1
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
            winTypeLiveData.value = LineDrawType.TYPE_1
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
            winTypeLiveData.value = LineDrawType.TYPE_1
            return true
        }
        // ===============================================================

        return false
    }


    fun win2(arr: Array<Array<BoardButton?>>): Boolean {
// ===============================================================
        var _isWin = false

        if (arr[0][0]?.type != null && arr[0][0]?.type == arr[0][1]?.type && arr[0][0]?.type == arr[0][2]?.type) {
            winTypeLiveData.value = LineDrawType.TYPE_1
            return true
        }

        if (arr[1][0]?.type != null && arr[1][0]?.type == arr[1][1]?.type && arr[1][0]?.type == arr[1][2]?.type) {
            winTypeLiveData.value = LineDrawType.TYPE_2
            return true
        }

        if (arr[2][0]?.type != null && arr[2][0]?.type == arr[2][1]?.type && arr[2][0]?.type == arr[2][2]?.type) {
            winTypeLiveData.value = LineDrawType.TYPE_3
            return true
        }

        // ===============================================================
        if (arr[0][0]?.type != null && arr[1][0]?.type == arr[0][0]?.type && arr[0][0]?.type == arr[2][0]?.type) {
            winTypeLiveData.value = LineDrawType.TYPE_4
            return true
        }

        if (arr[0][1]?.type != null && arr[1][1]?.type == arr[0][1]?.type && arr[0][1]?.type == arr[2][1]?.type) {
            winTypeLiveData.value = LineDrawType.TYPE_5
            return true
        }

        if (arr[0][2]?.type != null && arr[1][2]?.type == arr[0][2]?.type && arr[0][2]?.type == arr[2][2]?.type) {
            winTypeLiveData.value = LineDrawType.TYPE_6
            return true
        }

        // ===============================================================
        if (arr[0][0]?.type != null && arr[1][1]?.type == arr[0][0]?.type && arr[0][0]?.type == arr[2][2]?.type) {
            winTypeLiveData.value = LineDrawType.TYPE_7
            return true
        }

        // ===============================================================
        if (arr[2][0]?.type != null && arr[2][0]?.type == arr[1][1]?.type && arr[2][0]?.type == arr[0][2]?.type) {
            winTypeLiveData.value = LineDrawType.TYPE_8
            return true
        }
        // ===============================================================

        return false
    }

    fun refresh() {
        _refreshLiveData.value = true
    }
}