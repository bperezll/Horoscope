package com.example.horoscope.activities.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscope.R
import com.example.horoscope.adapters.HoroscopeAdapter
import com.example.horoscope.data.Horoscope

class MainActivity : AppCompatActivity() {

    var horoscopeList:List<Horoscope> = listOf(
        Horoscope.Aries,
        Horoscope.Taurus
    )

    lateinit var adapter:HoroscopeAdapter

    lateinit var  recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }
    fun initView() {
        recyclerView = findViewById(R.id.recyclerView)

        adapter = HoroscopeAdapter(horoscopeList)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter
    }
}

