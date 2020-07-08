package com.csgradqau.testingmaterial

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class home : AppCompatActivity() {
    lateinit var tv : TextView
    lateinit var it : Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        it = getIntent()
        tv = findViewById<TextView>(R.id.loggedInAs)
        var x = it.getStringExtra("email")
        tv.setText("Welcome"+" "+x)


    }
}