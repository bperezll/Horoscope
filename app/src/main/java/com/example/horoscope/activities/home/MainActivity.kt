package com.example.horoscope.activities.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscope.R
import com.example.horoscope.activities.DetailActivity
import com.example.horoscope.adapters.HoroscopeAdapter
import com.example.horoscope.data.Horoscope

class MainActivity : AppCompatActivity() {

    private var horoscopeList:List<Horoscope> = listOf(
        Horoscope.Aries,
        Horoscope.Taurus,
        Horoscope.Gemini,
        Horoscope.Cancer,
        Horoscope.Leo,
        Horoscope.Virgo,
        Horoscope.Libra,
        Horoscope.Scorpio,
        Horoscope.Sagittarius,
        Horoscope.Capricorn,
        Horoscope.Aquarius,
        Horoscope.Pisces
    )

    private lateinit var adapter:HoroscopeAdapter

    private lateinit var  recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView() {
        recyclerView = findViewById(R.id.recyclerView)

        adapter = HoroscopeAdapter(horoscopeList) {
            onItemClickListener(it)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        //recyclerView.layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = adapter
    }

    private fun onItemClickListener(position:Int) {
        val horoscope:Horoscope = horoscopeList[position]

        // val context:Context = this

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("HOROSCOPE_NAME", getString(horoscope.name))
        startActivity(intent)

        //Toast.makeText(this, getString(horoscope.name), Toast.LENGTH_LONG).show()
    }
}