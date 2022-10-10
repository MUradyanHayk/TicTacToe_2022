package com.example.tictactoe.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.tictactoe.R
import com.example.tictactoe.item.BoardButton
import com.example.tictactoe.item.BoardButtonType
import com.example.tictactoe.utils.dp
import com.example.tictactoe.utils.removeFromSuperview

class GameBoardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    var backgroundArray: Array<Array<BoardButton>> = Array(3) { Array(3) { createBoardButton() } }
    var foregroundArray: Array<Array<BoardButton?>> = Array(3) { Array<BoardButton?>(3) { null } }
    private var _paint = Paint(Paint.ANTI_ALIAS_FLAG)

    var drawType = LineDrawType.NONE
        set(value) {
            field = value
            drawByType()
        }
    var lineColor: Int = ContextCompat.getColor(context, R.color.teal_700)
        get() {
            return field
        }
        set(value) {
            field = value
            _paint.color = field
            invalidate()
        }

    private var rectF: RectF = RectF().apply {
        left = 2f.dp
        top = 2f.dp
        right = width() - 2f.dp
        bottom = height() - 2f.dp
    }

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.teal_700))
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        layoutParams = params
        _paint.strokeWidth = 6f.dp
        _paint.strokeCap = Paint.Cap.ROUND
        lineColor = ContextCompat.getColor(context, R.color.board_button_text_color_o)
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
//
//    override fun onDraw(canvas: Canvas?) {
//        if (drawType == LineDrawType.NONE) {
//            super.onDraw(canvas)
//            return
//        }
//        super.onDraw(canvas)
//        canvas?.drawLine(rectF.left, rectF.top, rectF.right, rectF.bottom, _paint)
//    }

    override fun dispatchDraw(canvas: Canvas?) {
        if (drawType == LineDrawType.NONE) {
            super.dispatchDraw(canvas)
            return
        }
        super.dispatchDraw(canvas)
        canvas?.drawLine(rectF.left, rectF.top, rectF.right, rectF.bottom, _paint)
    }

    fun drawByType() {
        when (drawType) {
            LineDrawType.TYPE_1 -> {
                rectF.left = 8f.dp
                rectF.top = BoardButton.SIZE / 2f + 2.dp
                rectF.right = width.toFloat() - 8f.dp
                rectF.bottom = rectF.top
            }
            LineDrawType.TYPE_2 -> {
                rectF.left = 8f.dp
                rectF.top = 2 * BoardButton.SIZE / 2f + 2.dp
                rectF.right = width.toFloat() - 8f.dp
                rectF.bottom = rectF.top
            }
            LineDrawType.TYPE_3 -> {
                rectF.left = 8f.dp
                rectF.top = 3 * BoardButton.SIZE / 2f + 2.dp
                rectF.right = width.toFloat() - 8f.dp
                rectF.bottom = rectF.top
            }
            LineDrawType.TYPE_4 -> {}
            LineDrawType.TYPE_5 -> {}
            LineDrawType.TYPE_6 -> {}
            LineDrawType.TYPE_7 -> {}
            LineDrawType.TYPE_8 -> {}
            LineDrawType.NONE -> {}
        }

        invalidate()
    }
}

enum class LineDrawType {
    TYPE_1,
    TYPE_2,
    TYPE_3,
    TYPE_4,
    TYPE_5,
    TYPE_6,
    TYPE_7,
    TYPE_8,
    NONE,
}