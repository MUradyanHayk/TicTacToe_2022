package com.muradyan.tictactoe.viewModel

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    val liveData = MutableLiveData<String>()
    init {
//        startTimer()
    }
    fun startTimer() {
        object : CountDownTimer(20000, 1000) {
            override fun onTick(p0: Long) {
//                tv?.text = (p0 / 1000).toString()
                liveData.value = (p0 / 1000).toString()
            }

            override fun onFinish() {
                Toast.makeText(getApplication(), "Finish", Toast.LENGTH_SHORT).show()
            }

        }.start()
    }
}