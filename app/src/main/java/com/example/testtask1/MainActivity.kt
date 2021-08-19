package com.example.testtask1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var tvCounter: TextView? = null
    var btnPlusOne: Button? = null
    var i: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvCounter = findViewById<TextView>(R.id.tv_counter)
        btnPlusOne = findViewById<Button>(R.id.btn_plus_one)
        tvCounter?.text = "$i"
        btnPlusOne?.setOnClickListener {
            i++
            tvCounter?.setText("$i")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("KEY_ctr", i)
        outState.putString("ctr_txt",tvCounter?.text.toString())

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        tvCounter?.text = savedInstanceState?.getString("ctr_txt")
        i=savedInstanceState?.getInt("KEY_ctr")
    }

}