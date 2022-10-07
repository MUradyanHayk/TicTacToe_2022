package com.example.tictactoe.utils

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics


object ScreenManager {
    fun getScreenWidth() = Resources.getSystem().displayMetrics.widthPixels
    fun getScreenHeight() = Resources.getSystem().displayMetrics.heightPixels
}