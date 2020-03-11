package com.fch.android_demo.intent

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fch.android_demo.R

class BActivity : AppCompatActivity() {

    private val Tag: String = "BActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        Log.i(Tag, "============onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(Tag, "============onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(Tag, "============onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(Tag, "============onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i(Tag, "============onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(Tag, "============onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(Tag, "============onDestroy")
    }
}