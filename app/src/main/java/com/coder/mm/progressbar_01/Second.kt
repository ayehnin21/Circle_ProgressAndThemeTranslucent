package com.coder.mm.progressbar_01

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.second.*

class Second : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        button2.setOnClickListener {
            finish()
        }
    }
}
