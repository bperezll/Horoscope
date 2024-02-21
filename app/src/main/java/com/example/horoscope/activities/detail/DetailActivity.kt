package com.example.horoscope.activities.detail

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.horoscope.R
import com.example.horoscope.data.Horoscope
import com.example.horoscope.data.Horoscope.Aquarius.image
import com.example.horoscope.data.HoroscopeProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    // To use with coroutine for the API text

    private var horoscopeId:String? = null
    private lateinit var horoscope: Horoscope

    private lateinit var horoscopeTextView:TextView
    private lateinit var horoscopeImageView:ImageView
    private lateinit var horoscopeLuckTextView:TextView
    private lateinit var horoscopeDateTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
    }

    private fun initView() {

        horoscopeId = intent.getStringExtra("HOROSCOPE_ID")
        horoscope = HoroscopeProvider().getHoroscope(horoscopeId!!)

        // Display the selected Zodiac sign

        horoscopeTextView = findViewById(R.id.horoscopeTextView)

        val name = intent.getStringExtra("HOROSCOPE_NAME")

        horoscopeTextView.text = name

        // Display the selected Zodiac icon

        horoscopeImageView = findViewById(R.id.horoscopeImageView)

        val image = intent.getIntExtra("HOROSCOPE_IMAGE", image)

        horoscopeImageView.setImageResource(image)

        // Display date range text of the sign

        horoscopeDateTextView = findViewById(R.id.horoscopeDateTextView)

        val date = intent.getStringExtra("HOROSCOPE_DATE")

        horoscopeDateTextView.text = date

        // Display the API text of Zodiac signs

        horoscopeLuckTextView = findViewById(R.id.horoscopeLuckTextView)

        horoscopeId = intent.getStringExtra("HOROSCOPE_NAME")

        horoscopeTextView.text = horoscopeId

        // Run coroutine

        getHoroscopeLuck()
    }

    private fun getHoroscopeLuck() {
        CoroutineScope(Dispatchers.IO).launch {
            // Llamada en segundo plano
            val result = HoroscopeProvider().getHoroscopeLuck(horoscopeId!!)
            runOnUiThread {
                // Modificar UI
                horoscopeLuckTextView.text = result
            }
        }
    }
}
