package com.example.tictactoe.item

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.tictactoe.R
import com.example.tictactoe.utils.ScreenManager
import com.example.tictactoe.utils.dp
import kotlin.math.roundToInt


class BoardButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    private var rectF: RectF = RectF().apply {
        left = 2f.dp
        top = 2f.dp
        right = SIZE - 2f.dp
        bottom = SIZE - 2f.dp
    }

    private var _paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bgColor: Int = ContextCompat.getColor(context, R.color.board_button_color)
        get() {
            return _paint.color
        }
        set(value) {
            field = value
            _paint.color = field
            invalidate()
        }

    companion object {

        val SIZE = (ScreenManager.getBoardSize() / 3).roundToInt()
    }

    init {
        val params = FrameLayout.LayoutParams(SIZE, SIZE)
        this.layoutParams = params
        this.gravity = Gravity.CENTER
//        this.setPadding(2.dp, 2.dp, 2.dp, 2.dp)
//        this.text = "X"
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 21f)
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent_color))
        setTextColor(ContextCompat.getColor(context, R.color.board_button_text_color))

        _paint.color = bgColor
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawRoundRect(rectF, 6f.dp, 6f.dp, _paint)
        super.onDraw(canvas)
    }

//    override fun dispatchDraw(canvas: Canvas?) {
//        super.dispatchDraw(canvas)
//        canvas?.drawRoundRect(rectF, 16f, 16f, _paint)
//    }
}