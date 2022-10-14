package com.example.tictactoe.utils

import android.content.res.Resources
import android.view.View
import android.view.ViewGroup

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


fun View.removeFromSuperview() {
    val viewParent = this.parent as? ViewGroup?
    viewParent?.removeView(this)
}