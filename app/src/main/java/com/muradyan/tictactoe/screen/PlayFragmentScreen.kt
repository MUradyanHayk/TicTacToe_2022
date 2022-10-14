package com.muradyan.tictactoe.screen

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.muradyan.tictactoe.R
import com.muradyan.tictactoe.item.BoardButtonType
import com.muradyan.tictactoe.ui.GameBoardView
import com.muradyan.tictactoe.utils.ScreenManager
import com.muradyan.tictactoe.utils.dp
import com.muradyan.tictactoe.utils.removeFromSuperview
import kotlin.math.roundToInt

class PlayFragmentScreen @JvmOverloads constructor(
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