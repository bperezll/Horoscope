package com.example.horoscope.activities.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.horoscope.R
import com.example.horoscope.data.Horoscope.Aquarius.image

class DetailActivity : AppCompatActivity() {

    private lateinit var horoscopeTextView:TextView
    private lateinit var horoscopeImageView:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()

    }

    private fun initView() {

        // Display the selected zodiac sign

        horoscopeTextView = findViewById(R.id.horoscopeTextView)

        val name = intent.getStringExtra("HOROSCOPE_NAME")

        horoscopeTextView.text = name


        // Display the selected zodiac icon

        horoscopeImageView = findViewById(R.id.horoscopeImageView)

        val image = intent.getIntExtra("HOROSCOPE_IMAGE", image)

        horoscopeImageView.setImageResource(image)
    }
}
