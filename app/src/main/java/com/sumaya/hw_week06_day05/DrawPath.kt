package com.sumaya.hw_week06_day05

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Button

class DrawPath @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var paint : Paint? = null
    private var path: Path? = null

    init {
        paint = Paint()
        path = Path()
        paint?.color = Color.BLACK
        paint?.strokeWidth = 10f
        paint?.style = Paint.Style.STROKE
        paint?.isAntiAlias= true
    }

    override fun onDraw(canvas: Canvas?) {
        canvas!!.drawPath(path!!, paint!!)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val x : Float = event!!.x
        val y : Float = event!!.y

        when(event!!.action){
            MotionEvent.ACTION_DOWN -> {
                path!!.moveTo(x,y)

            }

            MotionEvent.ACTION_MOVE -> {
                path!!.lineTo(x,y)

            }
            MotionEvent.ACTION_UP -> {

            }
            else -> {

            }
        }
        invalidate()
        return true

    }
}