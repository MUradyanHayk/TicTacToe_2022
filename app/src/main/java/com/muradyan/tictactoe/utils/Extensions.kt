package com.muradyan.tictactoe.utils

import android.content.res.Resources
import android.view.View
import android.view.ViewGroup
import com.google.android.material.internal.ViewUtils

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

fun View.setLeftPadding(padding: Int) {
    setPadding(padding, paddingTop, paddingRight, paddingBottom)
}

fun View.setTopPadding(padding: Int) {
    setPadding(paddingLeft, padding, paddingRight, paddingBottom)
}

fun View.setRightPadding(padding: Int) {
    setPadding(paddingLeft, paddingTop, padding, paddingBottom)
}

fun View.setBottomPadding(padding: Int) {
    setPadding(paddingLeft, paddingTop, paddingRight, padding)
}

fun View.setPaddings(padding: Int) {
    setPadding(padding, padding, padding, padding)
}