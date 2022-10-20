package com.muradyan.tictactoe.item

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.muradyan.tictactoe.R
import com.muradyan.tictactoe.utils.dp
import com.muradyan.tictactoe.utils.setTopPadding

class GameTypeItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var cardView: CardView? = null
    private var textView: TextView? = null
    private var imageView:ImageView? = null

    var isChecked:Boolean = false
        set(value) {
            if (field == value) {
                return
            }
            field = value
            changeButton(value)
        }

    var text: String
        get() {
            return textView?.text?.toString() ?: ""
        }
        set(value) {
            textView?.text = value
        }

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent_color))
        this.orientation = VERTICAL
//        this.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        createCardView()
        createTextView()
    }

    fun setImageResource(imageRes:Int) {
        imageView?.setImageResource(imageRes)
    }

    private fun createCardView() {
        cardView = CardView(context)
        val params = LayoutParams(LayoutParams.MATCH_PARENT, 0)
        cardView?.layoutParams = params
        params.weight = 1f
        cardView?.radius = 16f.dp
//        cardView?.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        cardView?.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white))
        addView(cardView)

        createImageView()
    }

    private fun createTextView() {
        textView = TextView(context)
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        textView?.setTopPadding(16.dp)
        textView?.layoutParams = params
        textView?.text = "sdkfsdffmsdflgdfgk"
        textView?.typeface = Typeface.DEFAULT_BOLD
        textView?.gravity = Gravity.CENTER
        textView?.setTextColor(ContextCompat.getColor(context, R.color.white))
        textView?.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10f)
        addView(textView)
    }

    private fun createImageView() {
        imageView = ImageView(context)
        imageView?.setImageResource(R.drawable.ic_networking_svgrepo_com__4_)
        imageView?.setPadding(14.dp, 14.dp, 14.dp, 14.dp)
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        imageView?.layoutParams = params
        imageView?.scaleType = ImageView.ScaleType.CENTER_INSIDE
        cardView?.addView(imageView)
    }

    fun changeButton(isChecked: Boolean) {
        if (isChecked) {
//            background = ContextCompat.getDrawable(context, R.drawable.google_play_add_credit_view_button_checked)
//            checkedImageView?.visibility = View.VISIBLE
//            titleTextView?.setTextColor(ContextCompat.getColor(context, R.color.color_black))
        } else {
//            background = ContextCompat.getDrawable(context, R.drawable.google_play_add_credit_view_button_unchecked)
//            checkedImageView?.visibility = View.GONE
//            titleTextView?.setTextColor(ContextCompat.getColor(context, R.color.color_white))
        }
        scaleAnimate(isChecked)
    }

    fun scaleAnimate(scale:Boolean) {
        animate().apply {
            if (scale) {
                scaleX(1.3f)
                scaleY(1.3f)
            } else {
                scaleX(1f)
                scaleY(1f)
            }
            duration = 180L
        }
    }
}