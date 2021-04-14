package com.example.zhoraapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.startButton)
        button.setOnClickListener {
            val nextIntent = Intent(this,AddPlayerActivity::class.java)
            startActivity(nextIntent)
        }
    }
}