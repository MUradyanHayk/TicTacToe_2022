package com.example.tictactoe.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.tictactoe.R
import com.example.tictactoe.item.BoardButton
import com.example.tictactoe.item.BoardButtonType
import com.example.tictactoe.utils.removeFromSuperview

class GameBoardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    var backgroundArray: Array<Array<BoardButton>> = Array(3) { Array(3) { createBoardButton() } }
    var foregroundArray: Array<Array<BoardButton?>> = Array(3) { Array<BoardButton?>(3){ null} }

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.teal_700))
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        layoutParams = params
    }

    private fun createBoardButton(): BoardButton {
        val btn = BoardButton(context)
//        val params = btn.layoutParams
        addView(btn)
        return btn
    }

    fun createBoardButtonByAnimation(): BoardButton {
        val btn = BoardButton(context)
        btn.scaleX = 0.7f
        btn.scaleY = 0.7f
//        val params = btn.layoutParams
        addView(btn)
        return btn
    }

    fun setParamsByPosition(params: LayoutParams, i: Int, j: Int) {
        params.topMargin = i * BoardButton.SIZE
        params.leftMargin = j * BoardButton.SIZE
    }
}