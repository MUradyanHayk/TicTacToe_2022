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


class BoardButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    private var rectF: RectF = RectF()

    private var _paint = Paint(Paint.ANTI_ALIAS_FLAG)

    companion object {

        val SIZE = ScreenManager.getScreenWidth() / 3
    }

    init {
        val params = FrameLayout.LayoutParams(SIZE, SIZE)
        this.layoutParams = params
        this.gravity = Gravity.CENTER
//        this.setPadding(2.dp, 2.dp, 2.dp, 2.dp)
        this.text = "X"
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 21f)
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent_color))


        _paint.color = ContextCompat.getColor(context,  R.color.board_button_color)

        rectF.left = 2f.dp
        rectF.top = 2f.dp
        rectF.right = SIZE - 2f.dp
        rectF.bottom = SIZE - 2f.dp
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRoundRect(rectF, 6f.dp, 6f.dp, _paint)

    }

//    override fun dispatchDraw(canvas: Canvas?) {
//        super.dispatchDraw(canvas)
//        canvas?.drawRoundRect(rectF, 16f, 16f, _paint)
//    }
}