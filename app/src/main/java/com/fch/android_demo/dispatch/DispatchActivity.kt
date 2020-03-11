package com.fch.android_demo.dispatch

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.fch.android_demo.R

class DispatchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dispatch)

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.v("DispatchActivity", "dispatchTouchEvent")
//        return super.dispatchTouchEvent(ev)
        return false
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.v("DispatchActivity", "onTouchEvent")
        return super.onTouchEvent(event)
    }


}