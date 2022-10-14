package com.example.tictactoe.screen

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.FrameLayout
import android.widget.RelativeLayout

class HomeFragmentScreen @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    var playWithYourSelfButton: Button? = null

    init {
        createPlayWithYourSelfButton()
    }

    private fun createPlayWithYourSelfButton() {
        playWithYourSelfButton = Button(context)
        val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        playWithYourSelfButton?.layoutParams = params
        playWithYourSelfButton?.text = "Play"
        addView(playWithYourSelfButton)
    }
}