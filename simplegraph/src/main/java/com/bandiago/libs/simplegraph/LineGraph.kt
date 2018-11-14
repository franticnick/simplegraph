package com.bandiago.libs.simplegraph

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.apply
import kotlin.collections.max
import kotlin.ranges.until

class LineGraph(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var mLineColor: Int = Color.argb(0xff, 0x00, 0, 0)
    var mLineThickness: Float = 1f

    var mSeries: Array<Float>? = null
    var mLinePaint: Paint? = null

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.LineGraph, 0, 0).apply {
            try {
                mLineColor = getColor(R.styleable.LineGraph_lineColor, Color.argb(0xff, 0, 0, 0)
                )
                mLineThickness = getFloat(R.styleable.LineGraph_lineThickness, 1f)
            } finally {
                recycle()
            }
        }

        //set Paint
        mLinePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = mLineColor
            strokeWidth = mLineThickness
            style = Paint.Style.FILL
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val minw: Int = paddingLeft + paddingRight + suggestedMinimumWidth
        val w: Int = resolveSizeAndState(minw, widthMeasureSpec, 1)

        val minh: Int = MeasureSpec.getSize(w) + paddingBottom + paddingTop
        val h: Int = resolveSizeAndState(minh, heightMeasureSpec, 0)

        setMeasuredDimension(w, h)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (mSeries != null) {
            drawGraph(canvas)
        }
    }

    fun drawGraph(canvas: Canvas) {
        val maxY: Float = if (mSeries!!.max() == 0f) 1.0f else mSeries!!.max()!!
        val offsetX = canvas.width.div(mSeries!!.size - 1).toFloat()
        val coefY = canvas.height.div(maxY)

        canvas.apply {
            var pointX = 0f
            for (i in 0 until mSeries!!.size - 1) {
                val pointY1 = height.toFloat() - mSeries!![i].times(coefY)
                val pointY2 = height.toFloat() - mSeries!![i + 1].times(coefY)
                drawLine(pointX, pointY1, (pointX + offsetX), pointY2, mLinePaint!!)
                pointX += offsetX
            }
        }
    }

    fun addSeries(series: Array<Float>) {
        mSeries = series
        invalidate()
        requestLayout()
    }

    fun setLineThickness(lineWidth: Float) {
        mLineThickness = lineWidth
        invalidate()
        requestLayout()
    }

    fun getLineThickness(): Float {
        return mLineThickness
    }

    fun setLineColor(lineColor: Int) {
        mLineColor = lineColor
        invalidate()
        requestLayout()
    }

    fun getLineColor(): Int {
        return mLineColor
    }

}