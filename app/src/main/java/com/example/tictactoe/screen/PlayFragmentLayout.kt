package com.example.tictactoe.screen

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.tictactoe.R
import com.example.tictactoe.item.BoardButtonType
import com.example.tictactoe.ui.GameBoardView
import com.example.tictactoe.utils.ScreenManager
import com.example.tictactoe.utils.dp
import com.example.tictactoe.utils.removeFromSuperview
import kotlin.math.roundToInt

class PlayFragmentLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {
    var gameBoardView: GameBoardView? = null
    var refreshImageView: ImageView? = null

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.screen_color))
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        layoutParams = params
        createGameBoardView()
        createRefreshImageView()
    }

    private fun createRefreshImageView() {
        refreshImageView = ImageView(context)
        refreshImageView?.setImageResource(R.drawable.ic_baseline_refresh_24)
        val params = LayoutParams(50.dp, 50.dp)
        params.gravity = Gravity.CENTER or Gravity.TOP
        params.topMargin = 32.dp
        refreshImageView?.layoutParams = params
        addView(refreshImageView)
    }

    private fun createGameBoardView() {
        gameBoardView = GameBoardView(context)
        gameBoardView?.setBackgroundColor(ContextCompat.getColor(context, R.color.board_color))
        val params = LayoutParams(ScreenManager.getBoardSize().roundToInt(), ScreenManager.getBoardSize().roundToInt())
        params.gravity = Gravity.CENTER or Gravity.BOTTOM
        params.bottomMargin = 32.dp
//        params.setMargins(16.dp, 16.dp, 16.dp, 16.dp)
        gameBoardView?.layoutParams = params
        addView(gameBoardView)
    }
}