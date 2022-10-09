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

    var backgroundArray = Array(3) { Array(3) { createBoardButton() } }
    var foregroundArray = Array(3) { mutableListOf<BoardButton?>() }
    var isClicked = false

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.teal_700))
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        layoutParams = params

        initBackgroundArrayPositions()
    }

    private fun createBoardButton(): BoardButton {
        val btn = BoardButton(context)
//        val params = btn.layoutParams
        addView(btn)
        return btn
    }

    private fun createBoardButtonByAnimation(): BoardButton {
        val btn = BoardButton(context)
        btn.scaleX = 0.7f
        btn.scaleY = 0.7f
//        val params = btn.layoutParams
        addView(btn)
        return btn
    }

    private fun initBackgroundArrayPositions() {
        for (i in backgroundArray.indices) {
            for (j in backgroundArray[i].indices) {
                val btn = backgroundArray[i][j]
                btn.setOnClickListener {
                    btn.isEnabled = false
                    createBoardButtonByAnimation().apply {
                        foregroundArray[i].add(this)
                        val params = layoutParams as FrameLayout.LayoutParams
                        setParamsByPosition(params, i, j)
                        bgColor = ContextCompat.getColor(context, R.color.board_button_color_2)
                        if (isClicked) {
                            type = BoardButtonType.X
                        } else {
                            type = BoardButtonType.O
                        }
                        isClicked = !isClicked
                        scaleAnimate()
                    }
                }
                val params = btn.layoutParams as FrameLayout.LayoutParams
                setParamsByPosition(params, i, j)
            }

        }
    }

    fun setParamsByPosition(params: LayoutParams, i: Int, j: Int) {
        params.topMargin = i * BoardButton.SIZE
        params.leftMargin = j * BoardButton.SIZE
    }

    fun refresh() {
        isClicked = false
        for (i in foregroundArray.indices) {
            for (j in foregroundArray[i].indices) {
                foregroundArray[i][j]?.removeFromSuperview()
            }
            foregroundArray[i].clear()
        }

        for (i in backgroundArray.indices) {
            for (j in backgroundArray.indices) {
                backgroundArray[i][j].isEnabled = true
            }
        }
        requestLayout()
    }
}