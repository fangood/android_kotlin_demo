package com.fch.android_demo.intent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fch.android_demo.R

class AActivity : AppCompatActivity() {
    private val Tag: String = "AActivity "
    private lateinit var buttonA: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        buttonA = findViewById(R.id.buttonA)
        buttonA.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@AActivity, BActivity::class.java)
            startActivity(intent)
        })
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