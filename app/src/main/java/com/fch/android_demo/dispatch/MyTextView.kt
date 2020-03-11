package com.fch.android_demo.dispatch

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.TextView

class MyTextView : TextView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    )

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.v("MyTextView", "dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.v("MyTextView", "onTouchEvent")
        return super.onTouchEvent(event)
    }

}