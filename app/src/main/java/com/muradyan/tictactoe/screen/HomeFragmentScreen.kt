package com.muradyan.tictactoe.screen

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.muradyan.tictactoe.R
import com.muradyan.tictactoe.item.GameTypesLayout
import com.muradyan.tictactoe.utils.dp
import com.muradyan.tictactoe.utils.setTopPadding

class HomeFragmentScreen @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    var playWithYourSelfButton: Button? = null
    var gameTypesLayout: GameTypesLayout? = null

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.screen_color))
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        layoutParams = params
        createGameTypesLayout()
        createPlayWithYourSelfButton()
    }

    private fun createPlayWithYourSelfButton() {
        playWithYourSelfButton = Button(context)
        val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        params.gravity = Gravity.CENTER
        playWithYourSelfButton?.layoutParams = params
        playWithYourSelfButton?.text = context.getString(R.string.play_text)
        playWithYourSelfButton?.background = ContextCompat.getDrawable(context, R.drawable.play_button_drawable)
        addView(playWithYourSelfButton)
    }

    private fun createGameTypesLayout() {
        gameTypesLayout = GameTypesLayout(context)

        val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        params.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
        gameTypesLayout?.layoutParams = params
        gameTypesLayout?.setTopPadding(32.dp)
        addView(gameTypesLayout)
    }
}