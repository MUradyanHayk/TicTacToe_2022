package com.muradyan.tictactoe.item

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.muradyan.tictactoe.R
import com.muradyan.tictactoe.utils.dp

class GameTypeItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var cardView: CardView? = null
    private var textView: TextView? = null

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

    private fun createCardView() {
        cardView = CardView(context)
        val params = LayoutParams(LayoutParams.MATCH_PARENT, 0)
        cardView?.layoutParams = params
        params.weight = 1f
        cardView?.radius = 16f.dp
//        cardView?.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        cardView?.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white))
        addView(cardView)
    }

    private fun createTextView() {
        textView = TextView(context)
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        textView?.setPadding(16.dp, 16.dp, 16.dp, 16.dp)
        textView?.layoutParams = params
        textView?.text = "sdkfsdffmsdflgdfgk"
        textView?.typeface = Typeface.DEFAULT_BOLD
        textView?.gravity = Gravity.CENTER
        textView?.setTextColor(ContextCompat.getColor(context, R.color.black))
        textView?.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10f)
        addView(textView)
    }

}