package com.example.tictactoe.screen

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.tictactoe.R
import com.example.tictactoe.ui.GameBoardView
import com.example.tictactoe.utils.ScreenManager
import com.example.tictactoe.utils.dp

class PlayFragmentLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {
    var gameBoardView: GameBoardView? = null

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.purple_200))
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        layoutParams = params
        createGameBoardView()
    }

    private fun createGameBoardView() {
        gameBoardView = GameBoardView(context)
        gameBoardView?.setBackgroundColor(ContextCompat.getColor(context, R.color.board_color))
        val params = LayoutParams(ScreenManager.getScreenWidth(), ScreenManager.getScreenWidth())
        params.gravity = Gravity.CENTER
//        params.setMargins(16.dp, 16.dp, 16.dp, 16.dp)
        gameBoardView?.layoutParams = params
        addView(gameBoardView)
    }
}