package com.example.tictactoe.utils

import android.content.res.Resources

val Int.dp: Int
    get() {
        return (this * Resources.getSystem().displayMetrics.density).toInt()
    }

val Long.dp: Long
    get() {
        return (this * Resources.getSystem().displayMetrics.density).toLong()
    }

val Float.dp: Float
    get() {
        return (this * Resources.getSystem().displayMetrics.density).toFloat()
    }

val Double.dp: Double
    get() {
        return (this * Resources.getSystem().displayMetrics.density).toDouble()
    }
