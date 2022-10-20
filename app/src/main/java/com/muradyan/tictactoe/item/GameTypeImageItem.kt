package com.muradyan.tictactoe.item


import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.muradyan.tictactoe.R
import com.muradyan.tictactoe.utils.ScreenManager
import com.muradyan.tictactoe.utils.dp
import kotlin.math.roundToInt


class GameTypeImageItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatImageView(context, attrs) {

    companion object {
        val SIZE = (ScreenManager.getBoardSize() / 3).roundToInt()
        private val TEXT_SIZE_X = 40f
        private val TEXT_SIZE_O = 48f
    }

    private var rectF: RectF = RectF()

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

    init {
        val params = FrameLayout.LayoutParams(SIZE, SIZE)
        this.layoutParams = params
//        this.setPadding(2.dp, 2.dp, 2.dp, 2.dp)
//        this.text = "X"
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent_color))

        _paint.color = bgColor
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        rectF.left = 2f.dp
        rectF.top = 2f.dp
        rectF.right = width - 2f.dp
        rectF.bottom = height - 2f.dp
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
