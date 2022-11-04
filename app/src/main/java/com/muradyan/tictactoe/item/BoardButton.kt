package com.muradyan.tictactoe.item

import android.animation.Animator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.muradyan.tictactoe.R
import com.muradyan.tictactoe.utils.ScreenManager
import com.muradyan.tictactoe.utils.dp
import kotlin.math.roundToInt


class BoardButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    companion object {
        val SIZE = (ScreenManager.getBoardSize() / 3).roundToInt()
        private val TEXT_SIZE_X = 40f
        private val TEXT_SIZE_O = 48f
    }

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

    var type: BoardButtonType = BoardButtonType.O
        set(value) {
            field = value
                typeface = Typeface.DEFAULT_BOLD
            if (value == BoardButtonType.X) {
//                text = "✖"
                text = "\u2715"
                setTextSize(TypedValue.COMPLEX_UNIT_DIP, TEXT_SIZE_X)
                setTextColor(ContextCompat.getColor(context, R.color.board_button_text_color_x))
            } else if (value == BoardButtonType.O) {
                setTextSize(TypedValue.COMPLEX_UNIT_DIP, TEXT_SIZE_O)
                setTextColor(ContextCompat.getColor(context, R.color.board_button_text_color_o))
//                text = "🞅"
                text = "\u25EF"
//                text = "\uD83D\uDF85"
//                text = "\u25EF"
//                text = "\u2B55"
//                typeface = Typeface.DEFAULT_BOLD

            }
        }

    init {
        val params = FrameLayout.LayoutParams(SIZE, SIZE)
        this.layoutParams = params
        this.gravity = Gravity.CENTER
//        this.setPadding(2.dp, 2.dp, 2.dp, 2.dp)
//        this.text = "X"
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, TEXT_SIZE_X)
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent_color))
        setTextColor(ContextCompat.getColor(context, R.color.board_button_text_color_o))

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

    fun scaleAnimate(callback: () -> Unit={}) {
        animate().apply {
            scaleX(1.05f)
            scaleY(1.05f)
            duration = 100
            start()
            setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator?) {

                }

                override fun onAnimationEnd(p0: Animator?) {
                    scaleX = 1f
                    scaleY = 1f
                    callback()
                }

                override fun onAnimationCancel(p0: Animator?) {
                }

                override fun onAnimationRepeat(p0: Animator?) {
                }
            })
        }
    }
}

enum class BoardButtonType {
    X, O
}