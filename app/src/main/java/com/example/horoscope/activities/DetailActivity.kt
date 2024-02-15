package com.example.horoscope.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.horoscope.R

class DetailActivity : AppCompatActivity() {

    private lateinit var horoscopeTextView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        horoscopeTextView = findViewById(R.id.horoscopeTextView)

        val name = intent.getStringExtra("HOROSCOPE_NAME")

        horoscopeTextView.text = name
    }
}