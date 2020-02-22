package com.fch.demo.module

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/demo/constraintLayoutActivity")
class ConstraintLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)


    }

}