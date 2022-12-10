package com.example.davaleba_9

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView3)
        textView2.movementMethod = LinkMovementMethod.getInstance()
        textView1.text = intent.getStringExtra("NAME")

    }
}