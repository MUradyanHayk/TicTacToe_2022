package com.example.tictactoe.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.tictactoe.R
import com.example.tictactoe.item.BoardButton
import com.example.tictactoe.utils.dp

class GameBoardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    var backgroundArray = Array(3) { Array(3) { createBoardButton() } }

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

    private fun initBackgroundArrayPositions() {
        for (i in backgroundArray.indices) {
            for (j in backgroundArray[i].indices) {
                val btn =  backgroundArray[i][j]
                val params = btn.layoutParams as FrameLayout.LayoutParams
                params.topMargin = i * BoardButton.SIZE
                params.leftMargin = j * BoardButton.SIZE
            }

        }
    }
}